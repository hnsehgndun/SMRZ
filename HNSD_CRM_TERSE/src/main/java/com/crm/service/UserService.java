package com.crm.service;



import com.crm.beans.User;

import java.util.List;

public interface UserService {
    //注册用户
    Integer addUser(User user);

    //登陆接口
    User login(String username);

    //查看是否用重复的账号id
    boolean getUserByUid(String uid);

    //查询所有用户信息
    List<User> getAllUser(String uphone,String uid);

    //重置密码
    boolean restPassword(String uid,String newpassword);

    //修改个人信息  暂时只有一个手机号可以修改
    boolean updateuserInfo(String uid,String uphone);

}
