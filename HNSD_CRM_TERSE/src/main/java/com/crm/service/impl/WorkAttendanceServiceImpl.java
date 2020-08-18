package com.crm.service.impl;

import com.crm.annonation.MyLogAnnonation;
import com.crm.beans.WorkAttendance;
import com.crm.beans.WorkLeave;
import com.crm.enums.OperationType;
import com.crm.enums.OperationUnit;
import com.crm.enums.WorkAttendanceFlagEnum;
import com.crm.mapper.WorkAttendanceMapper;
import com.crm.service.WorkAttendanceService;
import com.crm.service.WorkLeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WorkAttendanceServiceImpl implements WorkAttendanceService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private SimpleDateFormat daysimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //正常上班时间
    private static final String ONWORKTIME = "08:30:00";
    //正常下班时间
    private static final String DOWNWORKTIME = "17:30:00";

    private static final long MINUTES = 1000 * 60;
    @Autowired
    private WorkAttendanceMapper workAttendanceMapper;

    @Autowired
    private WorkLeaveService workLeaveService;

    @MyLogAnnonation(detail = "打卡", level = 1, operationUnit = OperationUnit.WORKATTENDANCE, operationType = OperationType.INSERT)
    @Override
    public boolean addWorkAttendance(String user_id, String work_attendance_desc) throws Exception {
        //获取打卡的时候的当前日期
        long nowtime = System.currentTimeMillis();
        //打卡时间
        Date todaydate = new Date(nowtime);
        String todayStr = daysimpleDateFormat.format(todaydate);
        WorkLeave workLeave = workLeaveService.getWorkLeaveByUserIdAndDate(user_id, todaydate);

        if (workLeave != null) {
            logger.error("用户{}的当前打卡时间为请假时间", user_id);
            return false;
        }
        WorkAttendance workAttendance = new WorkAttendance();
        workAttendance.setUserId(Integer.parseInt(user_id));
        workAttendance.setWorkDesc(work_attendance_desc);
        //设置打卡的日期
        workAttendance.setWorkDay(todayStr);
        //设置打卡时间
        workAttendance.setWorkAttendanceTime(todaydate);
        List<WorkAttendance> work_count = getWorkAttendanceByIdAndDate(workAttendance.getUserId(), todayStr);
        //正常上班的时间戳
        String workon_time = todayStr + " " + ONWORKTIME;
        Date simpleon_time = simpleDateFormat.parse(workon_time);
        //正常下班的时间戳
        String workdown_time = todayStr + " " + DOWNWORKTIME;
        Date simpledown_time = simpleDateFormat.parse(workdown_time);
        //如果打卡时间小于正常上班时间  则为正常上班
        if (todaydate.getTime() <= simpleon_time.getTime()) {
            workAttendance.setWorkFlag(WorkAttendanceFlagEnum.SIMPLE_ON_WORK.getWork_state());
            workAttendance.setWorkMinute(0);
            workAttendance.setDelayTime(0);
        } else {
            //打卡时间大于正常上班时间为迟到
            long difftime = todaydate.getTime() - simpleon_time.getTime();
            long diffminute = difftime / MINUTES;
            workAttendance.setWorkFlag(WorkAttendanceFlagEnum.LATE_WORK.getWork_state());
            workAttendance.setWorkMinute(0);
            //迟到的时间
            workAttendance.setDelayTime(Long.valueOf(diffminute).intValue());
        }
        //如果打卡时间大于正常下班时间则为下班打卡
        if (work_count.size() == 1) {
            //第一次打卡时间
            WorkAttendance attendance = work_count.get(0);
            long workdonetime = attendance.getWorkAttendanceTime().getTime();
            long difftime = todaydate.getTime() - workdonetime;
            long diffminute = difftime / MINUTES;
            //正常下班打卡
            if (todaydate.getTime() >= simpledown_time.getTime()) {
                workAttendance.setWorkFlag(WorkAttendanceFlagEnum.SIMPLE_DOWN_WORK.getWork_state());
                //设置工作多长时间
                workAttendance.setWorkMinute(Long.valueOf(diffminute).intValue());
                workAttendance.setDelayTime(0);
            } else {
                //打卡时间小于正常下班时间则早退打卡
                workAttendance.setWorkFlag(WorkAttendanceFlagEnum.LEVEL_WORK.getWork_state());
                //设置工作多长时间
                workAttendance.setWorkMinute(Long.valueOf(diffminute).intValue());
                long delaytime = simpledown_time.getTime() - todaydate.getTime();
                long delayminute = delaytime / MINUTES;
                //早退了多久
                workAttendance.setDelayTime(Long.valueOf(delayminute).intValue());
            }
        }
        return workAttendanceMapper.addWorkAttendance(workAttendance);
    }

    @MyLogAnnonation(detail = "获取个人打卡记录", level = 1, operationUnit = OperationUnit.WORKATTENDANCE, operationType = OperationType.SELECT)
    @Override
    public List<WorkAttendance> getAllWorkAttendance(String uphone) {
        return workAttendanceMapper.getAllWorkAttendance(uphone);
    }

    @Override
    public List<WorkAttendance> getWorkAttendanceByIdAndDate(Integer userId, String workDay) {
        return workAttendanceMapper.getWorkAttendanceByIdAndDate(userId, workDay);
    }
}
