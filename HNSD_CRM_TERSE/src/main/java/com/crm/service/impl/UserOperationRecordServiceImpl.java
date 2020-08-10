package com.crm.service.impl;

import com.crm.beans.UserOperationRecord;
import com.crm.mapper.UserOperationRecordMapper;
import com.crm.service.UserOperationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOperationRecordServiceImpl implements UserOperationRecordService {
    @Autowired
    private UserOperationRecordMapper userOperationRecordMapper;

    @Override
    public boolean addUserOperationRecord(UserOperationRecord userOperationRecord) {
        return userOperationRecordMapper.addUserOperationRecord(userOperationRecord);
    }
}
