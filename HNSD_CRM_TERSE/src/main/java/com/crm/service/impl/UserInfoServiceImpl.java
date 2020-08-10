package com.crm.service.impl;

import com.crm.beans.User;
import com.crm.beans.UserInfo;
import com.crm.mapper.UserInfoMapper;
import com.crm.mapper.UserMapper;
import com.crm.service.UserInfoService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
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
    public boolean insertUserInfo(UserInfo userInfo, String username) {
        //因为身份证要唯一,要参数校验
        Integer row = userInfoMapper.selectByIdcard(userInfo.getIdCard());
        if (row == null) {
            //没有实名过,那就去userinfo表登记信息,返回插入记录的主键id
            Integer result = userInfoMapper.insertUserInfo(userInfo);
            logger.info("userInfo表插入一条记录"+result);
            //向user表中做一个标记,证明已经认证过,realNameFlag
            //获取当前插入记录的id
            int userInfoId = userInfo.getId();
            boolean setRealNameFlagResult = userMapper.setRealNameFlag(userInfoId, username);
            logger.info("update  user表的realNameFlag字段"+setRealNameFlagResult);
            //userinfo表记录插入成功&&user表 realNameFlag 插入成功
            if (userInfoId != 0 && setRealNameFlagResult == true) {
                return true;
            } else {
                //认证失败
                return false;
            }
        } else {
            //表中存在身份证,已经认证
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
