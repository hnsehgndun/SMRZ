package com.crm.service;


import com.crm.beans.UserOperationRecord;

public interface UserOperationRecordService {
    //新增用户操作记录
    boolean addUserOperationRecord(UserOperationRecord userOperationRecord);
}
