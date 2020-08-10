package com.crm.service;



import com.crm.beans.WorkAttendance;

import java.util.List;

/**
 * 考勤方法的接口
 */
public interface WorkAttendanceService {
    //打卡
    boolean addWorkAttendance(String user_id,String work_attendance_desc) throws Exception;

    //查询所有打卡记录 根据用户昵称查找
    List<WorkAttendance> getAllWorkAttendance(String uphone);

    //根据日期和用户id查询打卡记录
    List<WorkAttendance> getWorkAttendanceByIdAndDate(Integer userId,String workDay);
}
