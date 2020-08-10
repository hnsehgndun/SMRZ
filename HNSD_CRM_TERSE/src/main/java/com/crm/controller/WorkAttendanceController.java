package com.crm.controller;

import com.crm.beans.WorkAttendance;
import com.crm.service.WorkAttendanceService;
import com.crm.util.responseUtil.JSONResponse;
import com.crm.util.responseUtil.ResSuccess;
import com.crm.util.responseUtil.ResponseUtils;
import com.crm.util.responseUtil.SystemErrors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 考勤接口
 */
@Api(value = "/考勤相关接口")
@RestController
@RequestMapping("/workattendance")
public class WorkAttendanceController {
    @Autowired
    private WorkAttendanceService workAttendanceService;

    @ApiOperation(value = "打卡接口")
    @ApiImplicitParam(name = "param",value = "用户id(user_id),打卡备注(work_attendance_desc)",required = true,dataType = "Map")
    @PostMapping("/addworkAttendance")
    public JSONResponse addWorkAttendance(@RequestBody  HashMap<String,String> param){
        //用户id
        String user_id = param.get("user_id");
        String work_attendance_desc = param.get("work_attendance_desc");
        boolean result = false;
        try {
            result = workAttendanceService.addWorkAttendance(user_id,work_attendance_desc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result){
            return ResponseUtils.success(ResSuccess.SYS_200);
        }else{
            return ResponseUtils.error(SystemErrors.SYS_400);
        }
    }

    @ApiOperation(value = "查询打卡记录")
    @GetMapping("/workattdendances")
    public JSONResponse getAllWorkAttendance(@RequestParam(value = "uphone",required = false) String uphone){
        List<WorkAttendance> list = workAttendanceService.getAllWorkAttendance(uphone);
        return ResponseUtils.success(ResSuccess.SYS_200,list);
    }



}
