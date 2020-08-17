package com.crm.mapper;

import com.crm.beans.WorkLeave;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author LCY
 * 请假接口
 * Date 2020/8/14
 */
@Repository
public interface WorkLeaveMapper {
    //新增请假记录
    boolean addworkLeave(WorkLeave workLeave);

    //根据用户id和打卡日期查询请假记录
    WorkLeave getWorkLeaveByUserIdAndDate(@Param("userId") String userId, @Param("workAttendanceDate") Date workAttendanceDate);

    //查询该人是否在请假期间请过假
    WorkLeave getWorkLeaveByWorkLeaveTime(@Param("userId") Integer userId, @Param("workLeaveStarttime") Date workLeaveStarttime);
}
