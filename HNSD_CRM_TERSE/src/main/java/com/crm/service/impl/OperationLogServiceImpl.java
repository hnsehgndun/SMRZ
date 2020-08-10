package com.crm.service.impl;

import com.crm.beans.OperationLog;
import com.crm.mapper.OperationLogMapper;
import com.crm.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public boolean addOperationLog(OperationLog operationLog) {
        return operationLogMapper.addOperationLog(operationLog);
    }
}
