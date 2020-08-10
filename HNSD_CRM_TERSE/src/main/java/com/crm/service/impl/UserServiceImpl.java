package com.crm.service.impl;

import com.crm.annonation.MyLogAnnonation;
import com.crm.beans.User;
import com.crm.enums.OperationType;
import com.crm.enums.OperationUnit;
import com.crm.mapper.UserMapper;
import com.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //需要加AOP日志的以这个格式
    @Override
    public boolean addUser(User user) {
        //注册时先判断此用户名是否已经存在
        boolean result = getUserByUid(user.getUid());
        if(result){
            return false;
        }
        return userMapper.addUser(user);
    }
    @Override
    public User login(String uid) {
        return userMapper.login(uid);
    }

    @MyLogAnnonation(detail = "通过id查找是否有重复的用户",level = 1,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public boolean getUserByUid(String uid) {
        return userMapper.getUserByUid(uid);
    }

    @MyLogAnnonation(detail = "获取所有用户",level = 1,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public List<User> getAllUser(String uphone, String uid) {
        return userMapper.getAllUser(uphone,uid);
    }

    @MyLogAnnonation(detail = "重置密码",level = 1,operationUnit = OperationUnit.USER,operationType = OperationType.UPDATE)
    @Override
    public boolean restPassword(String uid, String newpassword) {
        return userMapper.restPassword(uid,newpassword);
    }

    @MyLogAnnonation(detail = "更新用户个人信息",level = 1,operationUnit = OperationUnit.USER,operationType = OperationType.UPDATE)
    @Override
    public boolean updateuserInfo(String uid,String uphone) {
        return userMapper.updateuserInfo(uid,uphone);
    }
}
