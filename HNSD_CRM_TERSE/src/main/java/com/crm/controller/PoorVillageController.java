package com.crm.controller;

import com.crm.beans.NaturalVillage;
import com.crm.beans.PoorVillage;
import com.crm.service.NaturalVillageService;
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

    @Autowired
    NaturalVillageService naturalVillageService;

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
        if(StringUtils.isEmpty(poorVillage.getNaturalVillageId())){
            // 参数不完整 naturalVillageId
            mess += "自然村基本信息不能为空,";
        }
        if(StringUtils.isEmpty(poorVillage.getCountyId())){
            // 参数不完整
            mess += "所在县编号不能为空,";
        }
        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        // 村负责人信息
        NaturalVillage naturalVillage = naturalVillageService.selectByPrimaryKey(poorVillage.getNaturalVillageId());
        if(naturalVillage != null){
            poorVillage.setvAdminId(naturalVillage.getVillageChiefId());
        }
        poorVillageService.insertSelective(poorVillage);
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }

    // 选择自然村，然后申请为贫困村 自然村的一些贫困村信息资料
    @ApiOperation(value="修改贫困村信息")
    @PostMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public JSONResponse updateByPrimaryKeySelective(PoorVillage poorVillage){
        String mess = "";
        if(StringUtils.isEmpty(poorVillage.getVillageId())){
            // 参数不完整 villageId
            mess += "主键不能为空,";
        }
        // 县编号不用修改了
        if(StringUtils.isEmpty(poorVillage.getCountyId())){
            // 参数不完整
            mess += "所在县编号不能为空,";
        }
        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        // 村负责人信息
        NaturalVillage naturalVillage = naturalVillageService.selectByPrimaryKey(poorVillage.getNaturalVillageId());
        if(naturalVillage != null){
            poorVillage.setvAdminId(naturalVillage.getVillageChiefId());
        }
        poorVillageService.insertSelective(poorVillage);
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }


}
