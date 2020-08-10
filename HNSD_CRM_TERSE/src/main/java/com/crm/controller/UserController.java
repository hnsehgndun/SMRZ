package com.crm.controller;

import com.crm.beans.User;
import com.crm.beans.UserOperationRecord;
import com.crm.miaodiyun.IndustrySMS;
import com.crm.service.UserOperationRecordService;
import com.crm.service.UserService;
import com.crm.util.SpecialCharUtil;
import com.crm.util.httputil.IpUtils;
import com.crm.util.md5Util.Md5;
import com.crm.util.responseUtil.JSONResponse;
import com.crm.util.responseUtil.ResSuccess;
import com.crm.util.responseUtil.ResponseUtils;
import com.crm.util.responseUtil.SystemErrors;
import io.swagger.annotations.*;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "系统用户接口")
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserOperationRecordService userOperationRecordService;

    //获取动态验证码
    @ApiOperation(value = "获取动态验证码")
    @ApiImplicitParam(name = "phoneNum", value = "用户手机号", paramType = "path", required = true, dataType = "String")
    @GetMapping("/getCode/{phoneNum}")
    public void getCode(@ApiParam(value = "用户手机号",required = true) @PathVariable(value = "phoneNum") String phoneNum, HttpSession session) {
        String RandomNum = (int) (Math.random() * (999999 - 100000 + 1)) + 100000 + "";
        //秒滴科技的接口实现
        IndustrySMS.execute(phoneNum, RandomNum);
        //将随机数放入session中
        session.setAttribute("code", RandomNum);
    }

    //登陆
    @ApiImplicitParam(name = "param", value = "用户名(username)和密码(password)", required = true, dataType = "Map")
    @ApiOperation(value = "登陆",httpMethod = "POST")
    @PostMapping("/login")
    public JSONResponse login(HttpServletRequest request, @RequestBody HashMap<String,String> param){
        //查询库中数据
        User datauser = userService.login(param.get("username"));
        //对密码进行加密
        if(datauser != null){
            String md5password = Md5.md5(param.get("password"));
            if(md5password.equals(datauser.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("loginUser",datauser);
                String ipaddress = IpUtils.getLoaclIp(request);
                //用户登陆日志记录
                userOperationRecordService.addUserOperationRecord(new UserOperationRecord(datauser.getUsername(),"登陆了系统",ipaddress,new Date()));
                return ResponseUtils.success(ResSuccess.SYS_200,datauser);
            }
        }else {
            return ResponseUtils.error(SystemErrors.SYS_311);
        }
        return ResponseUtils.error(SystemErrors.SYS_312);
    }

    //用户进行注册
    @ApiOperation(value="注册")
    @ApiImplicitParam(name = "param", value = "用户名(username)、密码(password)、手机号(uphone)", required = true, dataType = "Map")
    @PostMapping("/register")
    public JSONResponse register(@RequestBody HashMap<String,String> param) {
        String md5Password = Md5.md5(param.get("password"));
        User user = new User();
        String username = param.get("username");
        String uphone = param.get("uphone");
        boolean specialresult = SpecialCharUtil.patternChar(username);
        boolean phoneresult = SpecialCharUtil.patternPhone(uphone);
        //判断用户名长度
        if(username.trim().length()<6 || username.trim().length()>15){
            return ResponseUtils.error(SystemErrors.SYS_309);
        }
        //用户名特殊字符
        if(specialresult){
            return ResponseUtils.error(SystemErrors.SYS_308);
        }
        //手机号匹配
        if(!phoneresult){
            return ResponseUtils.error(SystemErrors.SYS_310);
        }
        user.setUsername(username);
        user.setUphone(param.get("uphone"));
        user.setPassword(md5Password);
        Integer result = userService.addUser(user);
        if (result >0) {
            return ResponseUtils.success(ResSuccess.SYS_200, user);
        } else {
            return ResponseUtils.error(SystemErrors.SYS_400);
        }
    }

    //个人用户信息列表
    @ApiOperation(value = "获取所有用户")
    @GetMapping("/users")
    public JSONResponse getAllUser(@RequestParam(value = "uphone",required = false) String uphone,@RequestParam(value = "username",required = false)String username){
        List<User> alluser = userService.getAllUser(uphone, username);
        return ResponseUtils.success(ResSuccess.SYS_200,alluser);
    }

    @ApiOperation(value = "校验旧密码")
    @ApiImplicitParam(name = "param", value = "密码(oldpassword)", required = true, dataType = "Map")
    @PostMapping("/checkoldpassword")
    public JSONResponse checkPwd(HttpSession session, @RequestBody HashMap<String,String> param) {
        String oldpassword = param.get("oldpassword");
        //1.从Session中获取当前登录用户的User对象
        User user = (User) session.getAttribute("loginUser");
        String oldmd5password = Md5.md5(oldpassword);
        if(user.getPassword().equals(oldmd5password)) {
            //输入的旧密码正确
            return ResponseUtils.success(ResSuccess.SYS_200);
        }
        return ResponseUtils.error(SystemErrors.SYS_313);
    }

    //用户密码重置
    @ApiOperation(value = "用户密码重置")
    @ApiImplicitParam(name = "param",value = "新密码(newpassword)",required = true,dataType = "Map")
    @PostMapping("/restpassword")
    public JSONResponse restPassword(HttpSession session, @RequestBody HashMap<String,String> param){
        String newpassword = param.get("newpassword");
        String newmd5password = Md5.md5(newpassword);
        User user = (User)session.getAttribute("loginUser");
        boolean result = userService.restPassword(user.getUsername(), newmd5password);
        if (result) {
            return ResponseUtils.success(ResSuccess.SYS_200);
        } else {
            return ResponseUtils.error(SystemErrors.SYS_400);
        }
    }


    //修改个人资料接口
    @ApiOperation(value = "修改个人资料")
    @ApiImplicitParam(name = "param",value = "手机号(uphone),用户名(username)",required = true,dataType = "Map")
    @PutMapping("/updateUserInfo")
    public JSONResponse updateUserInfo(HttpSession session, @RequestBody HashMap<String,String> param){
        boolean result = userService.updateuserInfo(param.get("username"), param.get("uphone"));
        if(result){
            User newuser = userService.login(param.get("username"));
            //更新session
            session.setAttribute("loginUser",newuser);
            return ResponseUtils.success(ResSuccess.SYS_200,newuser);
        }else{
            return ResponseUtils.error(SystemErrors.SYS_400);
        }
    }

    //退出注销session
    @ApiOperation(value = "退出登录")
    @GetMapping("/logout")
    public JSONResponse logout(HttpSession session) {
        //1. 清空session中的用户信息
        session.removeAttribute("loginUser");
        //2. 再将session进行注销
        session.invalidate();
        return  ResponseUtils.success(ResSuccess.SYS_200);
    }
}
