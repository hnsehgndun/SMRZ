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
    @ApiImplicitParam(name = "workAttendance",value = "打卡信息实体",required = true,dataType = "WorkAttendance")
    @PostMapping("/addworkAttendance")
    public JSONResponse addWorkAttendance(@RequestBody WorkAttendance workAttendance){
        boolean result = false;
        try {
            result = workAttendanceService.addWorkAttendance(workAttendance);
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
    @ApiImplicitParam(name = "uphone",value = "用户手机号",paramType = "path" ,required = false,dataType = "String")
    @GetMapping("/workattdendances/{uphone}")
    public JSONResponse getAllWorkAttendance(@PathVariable("uphone") String uphone){
        List<WorkAttendance> list = workAttendanceService.getAllWorkAttendance(uphone);
        return ResponseUtils.success(ResSuccess.SYS_200,list);
    }



}
