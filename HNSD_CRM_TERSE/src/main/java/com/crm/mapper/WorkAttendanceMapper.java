package com.crm.mapper;


import com.crm.beans.WorkAttendance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkAttendanceMapper {
    //打卡
    boolean addWorkAttendance(WorkAttendance workAttendance) throws Exception;

    //查询所有打卡记录 根据用户昵称查找
    List<WorkAttendance> getAllWorkAttendance(@Param("uphone") String uphone);

    //根据日期和用户id查询打卡记录
    List<WorkAttendance> getWorkAttendanceByIdAndDate(@Param("userId") Integer userId,@Param("workDay") String workDay);
}
