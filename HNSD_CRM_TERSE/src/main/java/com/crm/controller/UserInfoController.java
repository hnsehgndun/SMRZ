package com.crm.controller;

import com.crm.beans.User;
import com.crm.beans.UserInfo;
import com.crm.service.UserInfoService;
import com.crm.util.responseUtil.JSONResponse;
import com.crm.util.responseUtil.ResSuccess;
import com.crm.util.responseUtil.ResponseUtils;
import com.crm.util.responseUtil.SystemErrors;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户信息
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    private UserInfoService userInfoService;
    //用户进行实名认证
    @ApiOperation(value="用户实名认证")
    @PostMapping("/realName")
    public JSONResponse realName(UserInfo userInfo, HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        String uid = user.getUid();
        boolean result = userInfoService.insertUserInfo(userInfo, uid);
        if (result) {
            return ResponseUtils.success(ResSuccess.SYS_200, user);
        } else {
            return ResponseUtils.error(SystemErrors.SYS_424);
        }
    }
}
