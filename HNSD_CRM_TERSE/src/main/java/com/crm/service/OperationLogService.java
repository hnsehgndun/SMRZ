package com.crm.service;


import com.crm.beans.OperationLog;

public interface OperationLogService {
    //新增aop操作记录
    boolean addOperationLog(OperationLog operationLog);
}
