package com.crm.service;


import com.crm.beans.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> findAllUserInfo();
    UserInfo findUserInfoByIdCard(String idCard);
    int deleteUserInfoByIdCard(String idCard);

    boolean insertUserInfo(UserInfo userInfo,String uid);
    int updateUserInfo(UserInfo userInfo);
}
