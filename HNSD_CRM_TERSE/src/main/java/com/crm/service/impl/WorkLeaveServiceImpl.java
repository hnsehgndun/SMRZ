package com.crm.service.impl;

import com.crm.beans.WorkLeave;
import com.crm.mapper.WorkLeaveMapper;
import com.crm.service.WorkLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * @author LCY
 * Date 2020/8/14
 */
@Service
public class WorkLeaveServiceImpl implements WorkLeaveService {
    @Autowired
    private WorkLeaveMapper workLeaveMapper;

    @Override
    public boolean addworkLeave(WorkLeave workLeave) {
        return workLeaveMapper.addworkLeave(workLeave);
    }

    @Override
    public WorkLeave getWorkLeaveByUserIdAndDate(String userId, Date workAttendanceDate) {
        return workLeaveMapper.getWorkLeaveByUserIdAndDate(userId, workAttendanceDate);
    }

    @Override
    public WorkLeave getWorkLeaveByWorkLeaveTime(Integer user_id, Date workLeaveStarttime) {
        return workLeaveMapper.getWorkLeaveByWorkLeaveTime(user_id, workLeaveStarttime);
    }
}
