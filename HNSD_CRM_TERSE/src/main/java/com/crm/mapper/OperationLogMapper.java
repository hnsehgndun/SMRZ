package com.crm.mapper;


import com.crm.beans.OperationLog;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationLogMapper {
    //新增aop记录日志
    boolean addOperationLog(OperationLog operationLog);
}
