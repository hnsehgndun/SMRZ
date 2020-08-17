package com.crm.service;

import com.crm.beans.WorkLeave;

import java.util.Date;

/**
 * @author LCY
 * 请假接口
 * Date 2020/8/14
 */
public interface WorkLeaveService {
    //请假
    boolean addworkLeave(WorkLeave workLeave);

    //根据用户id和打卡日期查询请假记录
    WorkLeave getWorkLeaveByUserIdAndDate(String userId,Date workAttendanceDate);

    //查询该人是否在请假期间请过假
    WorkLeave getWorkLeaveByWorkLeaveTime(Integer user_id,Date workLeaveStarttime);
}
