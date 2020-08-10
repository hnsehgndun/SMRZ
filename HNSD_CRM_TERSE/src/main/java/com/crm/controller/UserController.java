package com.crm.controller;

import com.crm.beans.User;
import com.crm.beans.UserOperationRecord;
import com.crm.miaodiyun.IndustrySMS;
import com.crm.service.UserOperationRecordService;
import com.crm.service.UserService;
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
    //@ApiOperation  swagger中的注解 value="接口说明"
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @ApiOperation(value = "登陆",httpMethod = "POST")
    @PostMapping("/login")
    public JSONResponse login(HttpServletRequest request, @RequestBody User user, HttpSession session){
        User datauser = userService.login(user.getUid());
        //对密码进行加密
        if(datauser != null){
            String md5password = Md5.md5(user.getPassword());
            if(md5password.equals(datauser.getPassword())){
                session.setAttribute("loginUser",datauser);
                String ipaddress = IpUtils.getLoaclIp(request);
                //用户登陆日志记录
                userOperationRecordService.addUserOperationRecord(new UserOperationRecord(datauser.getUid(),"登陆了系统",ipaddress,new Date()));
                return ResponseUtils.success(ResSuccess.SYS_200,datauser);
            }
        }else {
            return ResponseUtils.error(SystemErrors.SYS_400);
        }
        return ResponseUtils.error(SystemErrors.SYS_400);
    }
    //用户进行注册
    @ApiOperation(value="注册")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/register")
    public JSONResponse register(@RequestBody User user) {
        String md5Password = Md5.md5(user.getPassword());
        user.setPassword(md5Password);
        boolean result = userService.addUser(user);
        if (result) {
            return ResponseUtils.success(ResSuccess.SYS_200, user);
        } else {
            return ResponseUtils.error(SystemErrors.SYS_424);
        }
    }

    //个人用户信息列表
    @ApiOperation(value = "获取所有用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "uphone", value = "用户手机号", required = false, dataType = "String"),
                    @ApiImplicitParam(name = "uid", value = "用户id(昵称)", required = false, dataType = "String")})
    @GetMapping("/users")
    public JSONResponse getAllUser(@RequestParam(value = "uphone",required = false) String uphone, @RequestParam(value ="uid",required = false)  String uid){
        List<User> alluser = userService.getAllUser(uphone, uid);
        return ResponseUtils.success(ResSuccess.SYS_200,alluser);
    }

    @ApiOperation(value = "校验旧密码")
    @ApiImplicitParam(name = "oldpassword",value = "用户旧密码",paramType = "path",required = true,dataType = "String")
    @GetMapping("/checkoldpassword/{oldpassword}")
    public JSONResponse checkPwd(HttpSession session, @PathVariable(value = "oldpassword") String oldpassword) {
        //1.从Session中获取当前登录用户的User对象
        User user = (User) session.getAttribute("loginUser");
        String oldmd5password = Md5.md5(oldpassword);
        if(user.getPassword().equals(oldmd5password)) {
            //输入的旧密码正确
            return ResponseUtils.success(ResSuccess.SYS_200);
        }
        return ResponseUtils.error(SystemErrors.SYS_400);
    }

    //用户密码重置
    @ApiOperation(value = "用户密码重置")
    @ApiImplicitParam(name = "param",value = "key为 newpassword 格式为json",required = true,dataType = "Map")
    @PostMapping("/restpassword")
    public JSONResponse restPassword(HttpSession session, @RequestBody Map<String,String> param){
        String newpassword = param.get("newpassword");
        String newmd5password = Md5.md5(newpassword);
        User user = (User)session.getAttribute("loginUser");
        boolean result = userService.restPassword(user.getUid(), newmd5password);
        if (result) {
            return ResponseUtils.success(ResSuccess.SYS_200);
        } else {
            return ResponseUtils.error(SystemErrors.SYS_400);
        }
    }


    //修改个人资料接口
    @ApiOperation(value = "修改个人资料")
    @ApiImplicitParam(name = "user",value = "用户实体",required = true,dataType = "User")
    @PutMapping("/updateUserInfo")
    public JSONResponse updateUserInfo(HttpSession session, @RequestBody User user){
        boolean result = userService.updateuserInfo(user.getUid(), user.getUphone());
        if(result){
            User newuser = userService.login(user.getUid());
            session.setAttribute("loginUser",newuser);
            return ResponseUtils.success(ResSuccess.SYS_200);
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
