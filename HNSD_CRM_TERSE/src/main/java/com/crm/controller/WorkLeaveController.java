package com.crm.controller;

import com.crm.beans.WorkLeave;
import com.crm.service.WorkLeaveService;
import com.crm.util.responseUtil.JSONResponse;
import com.crm.util.responseUtil.ResSuccess;
import com.crm.util.responseUtil.ResponseUtils;
import com.crm.util.responseUtil.SystemErrors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/**
 * @author LCY
 * Date 2020/8/14
 */
@Api(value = "请假接口")
@RequestMapping("/leave")
@RestController
public class WorkLeaveController {
    @Autowired
    private WorkLeaveService workLeaveService;

    @ApiOperation(value = "请假")
    @PostMapping("/workleave")
    public JSONResponse addWorkLeave(@RequestBody WorkLeave workLeave){
        if(workLeave.getLeaveStarttime().getTime() >= workLeave.getLeaveEndtime().getTime()){
            //请假开始日期小于结束日期  非法参数
            return ResponseUtils.error(SystemErrors.SYS_308);
        }
        //请假人得请假日期必须大于之前请过的假
        WorkLeave workLeaveByWorkLeaveTime = workLeaveService.getWorkLeaveByWorkLeaveTime(workLeave.getUserId(), workLeave.getLeaveStarttime());
        if(workLeaveByWorkLeaveTime !=null){
            return ResponseUtils.error(SystemErrors.SYS_308);
        }
        workLeave.setLeaveStatu(0);
        boolean result = workLeaveService.addworkLeave(workLeave);
        if(result){
            return ResponseUtils.success(ResSuccess.SYS_200);
        }else{
            return ResponseUtils.error(SystemErrors.SYS_400);
        }
    }
}
