package com.crm.service.impl;

import com.crm.beans.User;
import com.crm.beans.UserInfo;
import com.crm.mapper.UserInfoMapper;
import com.crm.mapper.UserMapper;
import com.crm.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insertUserInfo(UserInfo userInfo, String uid) {
        //判断是否之前实名过
        User user = userMapper.selectRealName(uid);
        if (user == null) {
            System.out.println("下一步是想userinfo表中插入信息");
            //没有实名过,那就去userinfo表登记信息
            userInfoMapper.insertUserInfo(userInfo);
            //同时根据idCarid获取userInfo中的id
            UserInfo userInfoId = userInfoMapper.selectByIdcard(userInfo.getIdCard());
            //向user表中做一个标记,证明已经认证过,realNameFlag
            userMapper.setRealNameFlag(userInfoId.getId());
            return true;
        } else {
            //实名过,不需要再进行实名
            return false;
        }
    }

    @Override
    public List<UserInfo> findAllUserInfo() {

//        pager指明需要显示的页数,size指明每页数据的个数,Sort.Direction.DESC指明降序排序,"competitionStartTime"为需要排序的属性
        int pager = 1;
        int size = 3;
//        PageRequest pageRequest = new PageRequest(pager, size, Sort.Direction.DESC);
////            进行查询,查询后的对象封装到page里
//        Page<UserInfo> page = userInfoMapper.findAllUserInfo(pageRequest);
        return userInfoMapper.findAllUserInfo();
    }

    @Override
    public UserInfo findUserInfoByIdCard(String idCard) {
        return userInfoMapper.findUserInfoByIdCard(idCard);
    }

    @Override
    public int deleteUserInfoByIdCard(String idCard) {
        return userInfoMapper.deleteUserInfoByIdCard(idCard);
    }


    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }
}
