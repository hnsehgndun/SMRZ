package com.crm.mapper;


import com.crm.beans.UserOperationRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOperationRecordMapper {
    //新增用户操作记录
    boolean addUserOperationRecord(UserOperationRecord userOperationRecord);
}
