package com.crm.controller;

import com.crm.beans.PoorVillage;
import com.crm.service.PoorVillageService;
import com.crm.util.responseUtil.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 贫困村信息
 */
@Api(value = "贫困村信息接口")
@Controller
@RequestMapping("/poorVillage")
public class PoorVillageController {

    @Autowired
    PoorVillageService poorVillageService;

    // @ApiImplicitParam(name = "userInfo", value = "用户认证信息实体类userInfo", required = true, dataType = "UserInfo")
    @ApiOperation(value="分页获取贫困村信息")
    @GetMapping("/pageList")
    @ResponseBody
    public JSONResponse poorVillageService(PoorVillage poorVillage, PageBean<PoorVillage> page){
        PageBean<PoorVillage> poorVillagePageList= poorVillageService.getPoorVillageList(poorVillage, page);
        return ResponseUtils.success(ResSuccess.SYS_200, poorVillagePageList);
    }

    // 选择自然村，然后申请为贫困村
    @ApiOperation(value="添加贫困村信息")
    @PostMapping("/addPoorVillage")
    @ResponseBody
    public JSONResponse addPoorVillage(PoorVillage poorVillage){
        String mess = "";
        if(StringUtils.isEmpty(poorVillage.getCountyId())){
            // 参数不完整
            mess += "贫困县编号countyId不能为空,";
        }
        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        poorVillageService.insertSelective(poorVillage);
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }


}
