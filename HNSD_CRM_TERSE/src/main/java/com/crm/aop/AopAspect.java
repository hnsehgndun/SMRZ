package com.crm.aop;

import com.alibaba.fastjson.JSON;
import com.crm.annonation.MyLogAnnonation;
import com.crm.beans.OperationLog;
import com.crm.beans.User;
import com.crm.interceptor.LoginHandlerInterceptor;
import com.crm.service.OperationLogService;
import com.crm.util.responseUtil.ResponseUtils;
import com.crm.util.responseUtil.SystemErrors;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Aspect
@Component
public class AopAspect {
    @Autowired
    private OperationLogService operationLogService;
    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     */

    @Pointcut("@annotation(com.crm.annonation.MyLogAnnonation)")
    public void operationLog() {
    }


    /**
     * 环绕增强，相当于MethodInterceptor
     */

    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        HttpSession session = request.getSession();
        User sessionuser = (User) session.getAttribute("loginUser");
        if(sessionuser == null){
            try {
                LoginHandlerInterceptor.returnJson(response, ResponseUtils.error(SystemErrors.SYS_401));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            Object res = null;
            long time = System.currentTimeMillis();
            try {
                res = joinPoint.proceed();
                time = System.currentTimeMillis() - time;
                return res;
            } finally {
                try {
                    //方法执行完成后增加日志
                    addOperationLog(joinPoint, res, Long.valueOf(time).intValue(),sessionuser);
                } catch (Exception e) {
                    System.err.println("LogAspect 操作失败：" + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private void addOperationLog(JoinPoint joinPoint, Object res, int time, User sessionuser) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        OperationLog operationLog = new OperationLog();
        operationLog.setRunTime(time);
        operationLog.setReturnValue(JSON.toJSONString(res));
        operationLog.setId(UUID.randomUUID().toString().replace("-",""));
        operationLog.setArgs(JSON.toJSONString(joinPoint.getArgs()));
        operationLog.setOperationDate(new Date());
        operationLog.setMethod(signature.getDeclaringTypeName() + "." + signature.getName());
        operationLog.setUid(sessionuser.getUid());
        MyLogAnnonation annotation = signature.getMethod().getAnnotation(MyLogAnnonation.class);
        if (annotation != null) {
            operationLog.setLevel(annotation.level());
            operationLog.setDescribe(getDetail(((MethodSignature) joinPoint.getSignature()).getParameterNames(), joinPoint.getArgs(), annotation,sessionuser));
            operationLog.setOperationType(annotation.operationType().getValue());
            operationLog.setOperationUnit(annotation.operationUnit().getValue());
        }
        //TODO 这里保存日志
       operationLogService.addOperationLog(operationLog);
    }


    /**
     * 对当前登录用户和占位符处理
     *
     * @param argNames   方法参数名称数组
     * @param args       方法参数数组
     * @param annotation 注解信息
     * @return 返回处理后的描述
     */

    private String getDetail(String[] argNames, Object[] args, MyLogAnnonation annotation,User user) {
        Map<Object, Object> map = new HashMap<>(4);
        for (int i = 0; i < argNames.length; i++) {
            map.put(argNames[i], args[i]);
        }

        String detail = annotation.detail();
        try {
            detail = "'" + "#{"+user.getUid()+"}" + "'=》" + annotation.detail();
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                Object k = entry.getKey();
                Object v = entry.getValue();
                detail = detail.replace("{{" + k + "}}", JSON.toJSONString(v));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
    }


    /**
     * 处理完请求，返回内容
     *
     * @param ret
     */

    @AfterReturning(returning = "ret", pointcut = "operationLog()")
    public void doAfterReturning(Object ret) {
    }


    /**
     * 后置异常通知
     */

    @AfterThrowing("operationLog()")
    public void throwss(JoinPoint jp) {
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */

    @After("operationLog()")
    public void after(JoinPoint jp) {
    }
}

