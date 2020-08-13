package com.crm.service;



import com.crm.beans.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //注册用户
    Integer addUser(User user);

    //登陆接口
    User login(String username);

    //查看是否用重复的账号id
    boolean getUserByUserName(String username);

    //查询所有用户信息
    List<User> getAllUser(String uphone,String username);

    //重置密码
    boolean restPassword(String username,String newpassword);

    //修改个人信息  暂时只有一个手机号可以修改
    boolean updateuserInfo(String username,String uphone);

    //把userinfo表的id放入user表的userinfo_id字段中
    boolean updateUserinfoId(Integer userInfoId, String username);

}
