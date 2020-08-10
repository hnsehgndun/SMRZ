package com.crm.mapper;



import com.crm.beans.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //注册用户
    Integer addUser(User user);

    //登陆接口
    User login(@Param("username") String username);

    //查看是否用重复的账号id
    boolean getUserByUid(String username);

    //查看所有用户信息
    List<User> getAllUser(@Param("uphone") String uphone,@Param("username") String username);

    //重置密码
    boolean restPassword(@Param("username") String username,@Param("newpassword") String newpassword);

    //修改个人信息  暂时只有一个手机号可以修改
    boolean updateuserInfo(@Param("username") String username,@Param("uphone") String uphone);

    //查user表中是否认证的标志
    User selectRealName(@Param("username") String username);

    //把userinfo表的id放入user表的realName_flag字段中
    int setRealNameFlag(int id);
}
