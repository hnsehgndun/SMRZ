package com.crm.service.impl;

import com.crm.annonation.MyLogAnnonation;
import com.crm.beans.User;
import com.crm.enums.OperationType;
import com.crm.enums.OperationUnit;
import com.crm.mapper.UserMapper;
import com.crm.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //需要加AOP日志的以这个格式
    @Override
    public Integer addUser(User user) {
        //注册时先判断此用户名是否已经存在
        boolean result = getUserByUserName(user.getUsername());
        if(result){
            return 0;
        }
        return userMapper.addUser(user);
    }
    @Override
    public User login(String username) {
        return userMapper.login(username);
    }

    @MyLogAnnonation(detail = "通过id查找是否有重复的用户",level = 1,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public boolean getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }

    @MyLogAnnonation(detail = "获取所有用户",level = 1,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public List<User> getAllUser(String uphone, String username) {
        return userMapper.getAllUser(uphone,username);
    }

    @MyLogAnnonation(detail = "重置密码",level = 1,operationUnit = OperationUnit.USER,operationType = OperationType.UPDATE)
    @Override
    public boolean restPassword(String username, String newpassword) {
        return userMapper.restPassword(username,newpassword);
    }

    @MyLogAnnonation(detail = "更新用户个人信息",level = 1,operationUnit = OperationUnit.USER,operationType = OperationType.UPDATE)
    @Override
    public boolean updateuserInfo(String username,String uphone) {
        return userMapper.updateuserInfo(username,uphone);
    }

    @Override
    public boolean updateUserinfoId(Integer userInfoId, String username) {
        return userMapper.updateUserinfoId(userInfoId,username);
    }
}
