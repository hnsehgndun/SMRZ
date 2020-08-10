package com.crm.mapper;


import com.crm.beans.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
    //根据idcarid获取userinfo表中的id
    UserInfo selectByIdcard(String idCard);
    //实名认证登记信息
    int insertUserInfo(UserInfo userInfo);



    List<UserInfo> findAllUserInfo();
    UserInfo findUserInfoByIdCard(String idCard);
    int deleteUserInfoByIdCard(String idCard);
    int updateUserInfo(UserInfo userInfo);

}
