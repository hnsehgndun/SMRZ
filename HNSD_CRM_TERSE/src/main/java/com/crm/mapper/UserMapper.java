package com.crm.mapper;



import com.crm.beans.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //注册用户
    boolean addUser(User user);

    //登陆接口
    User login(@Param("uid") String uid);

    //查看是否用重复的账号id
    boolean getUserByUid(String uid);

    //查看所有用户信息
    List<User> getAllUser(String uphone,String uid);

    //重置密码
    boolean restPassword(String uid,String newpassword);

    //修改个人信息  暂时只有一个手机号可以修改
    boolean updateuserInfo(String uid,String uphone);

    //把userinfo表的id放入user表的realName_flag字段中
    boolean setRealNameFlag(@Param("userInfoId") Integer userInfoId,@Param("uid") String uid);
}
