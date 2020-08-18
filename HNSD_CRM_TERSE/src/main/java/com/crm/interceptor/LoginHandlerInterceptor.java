package com.crm.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.crm.util.responseUtil.JSONResponse;
import com.crm.util.responseUtil.ResponseUtils;
import com.crm.util.responseUtil.SystemErrors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 定义登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //调用目标方法之前被拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            return true;
        }
        logger.error(request.getRequestURL()+"没有登陆系统就访问其他接口,被拦截了!!!");
        returnJson(response, ResponseUtils.error(SystemErrors.SYS_401));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public static void returnJson(HttpServletResponse response, JSONResponse jsonresponse) throws Exception {
        ServletOutputStream outputStream = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            outputStream = response.getOutputStream();
            String responseStr = JSONObject.toJSON(jsonresponse).toString();
            byte[] bytes = responseStr.getBytes();
            response.setContentLength(bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                outputStream.write(bytes);
            }
        } catch (IOException e) {
        } finally {
            if (outputStream != null)
                outputStream.close();
        }
    }
}
