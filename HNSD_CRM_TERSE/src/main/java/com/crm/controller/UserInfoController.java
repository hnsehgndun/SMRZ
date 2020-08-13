package com.crm.controller;

import com.crm.beans.User;
import com.crm.beans.UserInfo;
import com.crm.service.UserInfoService;
import com.crm.util.responseUtil.JSONResponse;
import com.crm.util.responseUtil.ResSuccess;
import com.crm.util.responseUtil.ResponseUtils;
import com.crm.util.responseUtil.SystemErrors;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 用户信息
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    //用户进行实名认证
    @ApiImplicitParam(name = "userInfo", value = "用户认证信息实体类userInfo", required = true, dataType = "UserInfo")
    @ApiOperation(value="用户实名认证",httpMethod = "POST")
    @PostMapping("/realName")
    public JSONResponse realName(@RequestBody UserInfo userInfo, HttpSession session){
        //用户登录以后所有信息都在session中
        User user = (User) session.getAttribute("loginUser");
        //获取账号名usernaem
        String username = user.getUsername();
        //判断userInfoid认证标志位是否为空,为空则可以认证
        if (user.getUserinfoId() == null) {
            String regex = "(^\\d{18}$)|(^\\d{15}$)";
            String idCard = userInfo.getIdCard();
            if(idCard.matches(regex)){
                boolean result = userInfoService.insertUserInfo(userInfo, username);
                if (result) {
                    return ResponseUtils.success(ResSuccess.SYS_200);
                }
                return ResponseUtils.error("500", "认证过程失败,身份证号已经存在");
            }else{
                return ResponseUtils.error("500", "身份证号格式错误");
            }
        } else {
            return ResponseUtils.error(SystemErrors.SYS_424);
        }
    }
}
