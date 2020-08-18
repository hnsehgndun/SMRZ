package com.crm.controller;

import com.crm.beans.NaturalVillage;
import com.crm.beans.User;
import com.crm.service.NaturalVillageService;
import com.crm.util.DateUtil;
import com.crm.util.ValidatorUtil;
import com.crm.util.responseUtil.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * 贫困村信息
 */
@Api(value = "自然村信息接口")
@Controller
@RequestMapping("/naturalVillage")
public class NaturalVillageController {

    @Autowired
    NaturalVillageService naturalVillageService;

    @ApiOperation(value="分页获取自然村信息")
    @GetMapping("/pageList")
    @ResponseBody
    public JSONResponse naturalVillageService(NaturalVillage naturalVillage, PageBean<NaturalVillage> page){
        PageBean<NaturalVillage> naturalVillagePageList= naturalVillageService.getNaturalVillageList(naturalVillage, page);
        return ResponseUtils.success(ResSuccess.SYS_200, naturalVillagePageList);
    }

    @ApiOperation(value="添加自然村信息")
    @PostMapping("/addNaturalVillage")
    @ResponseBody
    public JSONResponse addNaturalVillage(HttpSession session, NaturalVillage naturalVillage){
        String mess = "";

        User user = (User) session.getAttribute("loginUser");

        if(StringUtils.isEmpty(naturalVillage.getNaturalVillageCode())){
            // 参数不完整naturalVillageCode
            mess += "自然村编号不能为空,";
        }

        if(StringUtils.isEmpty(naturalVillage.getNaturalVillageName())){
            // 参数不完整naturalVillageName
            mess += "自然村名称不能为空,";
        }

        if(naturalVillage.getNaturalVillageAddress() == null){
            // 参数不完整naturalVillageAddress
            mess += "自然村地址不能为空,";
        }

        if(naturalVillage.getVillageChiefId()  == null){
            // 参数不完整villageChiefId
            mess += "自然村负责人不能为空,";
        }

        if(!StringUtils.isEmpty(naturalVillage.getNaturalVillageCode())){
            // 参数完整不重复
            NaturalVillage naturalVillageParam = new NaturalVillage();
            naturalVillageParam.setNaturalVillageCode(naturalVillage.getNaturalVillageCode());
            int count = naturalVillageService.checkOnlyNaturalVillage(naturalVillageParam);
            if(count > 0){
                // naturalVillageCode
                mess += "自然村编号有重复值,";
            }
        }

        // 经度不为空时
        if(!StringUtils.isEmpty(naturalVillage.getLongitude())){
            // 参数完整不重复
            Boolean flag = ValidatorUtil.isLongitude(naturalVillage.getLongitude());
            if(!flag){
                mess += "经度longitude数值格式不正确,";
            }
        }

        // 纬度不为空时
        if(!StringUtils.isEmpty(naturalVillage.getLatitude())){
            // 参数完整不重复
            Boolean flag = ValidatorUtil.isLatitude(naturalVillage.getLatitude());
            if(!flag){
                // latitude
                mess += "纬度数值格式不正确,";
            }
        }

        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }

        if(user != null){
            naturalVillage.setCreateUserId(user.getId());
        }
        naturalVillage.setCreateTime(DateUtil.getNow());

        naturalVillageService.insertSelective(naturalVillage);
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }

    @ApiOperation(value="验证自然村编号是否重复")
    @GetMapping("/checkOnlyNaturalVillageCode")
    @ResponseBody
    public JSONResponse checkOnlyNaturalVillageCode(NaturalVillage naturalVillage){
        String mess = "";

        if(StringUtils.isEmpty(naturalVillage.getNaturalVillageCode())){
            // 参数不完整 naturalVillageCode
            mess += "自然村编号不能为空,";
        }

        if(!StringUtils.isEmpty(naturalVillage.getNaturalVillageCode())){
            // 参数完整不重复
            NaturalVillage naturalVillageParam = new NaturalVillage();
            naturalVillageParam.setNaturalVillageCode(naturalVillage.getNaturalVillageCode());
            int count = naturalVillageService.checkOnlyNaturalVillage(naturalVillageParam);
            if(count > 0){
                // naturalVillageCode
                mess += "自然村编号有重复值,";
            }
        }
        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }


    @ApiOperation(value="验证经度值")
    @GetMapping("/checkOnlyNaturalVillageLongitude")
    @ResponseBody
    public JSONResponse checkOnlyNaturalVillageLongitude(NaturalVillage naturalVillage){
        String mess = "";

        // 经度不为空时
        if(!StringUtils.isEmpty(naturalVillage.getLongitude())){
            // 参数完整不重复
            Boolean flag = ValidatorUtil.isLongitude(naturalVillage.getLongitude());
            if(!flag){
                // longitude
                mess += "经度数值格式不正确,";
            }
        }

        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }

    @ApiOperation(value="验证纬度值")
    @GetMapping("/checkOnlyNaturalVillageLatitude")
    @ResponseBody
    public JSONResponse checkOnlyNaturalVillageLatitude(NaturalVillage naturalVillage){
        String mess = "";

        // 纬度不为空时
        if(!StringUtils.isEmpty(naturalVillage.getLatitude())){
            // 参数完整不重复
            Boolean flag = ValidatorUtil.isLatitude(naturalVillage.getLatitude());
            if(!flag){
                // latitude
                mess += "纬度数值格式不正确,";
            }
        }

        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }

    @ApiOperation(value="验证更新时自然村信息是否重复")
    @GetMapping("/checkOnlyUpdateNaturalVillageCode")
    @ResponseBody
    public JSONResponse checkOnlyUpdateNaturalVillageCode(NaturalVillage naturalVillage){
        String mess = "";
        if(naturalVillage.getNaturalVillageId() == null){
            // 参数不完整 naturalVillageId
            mess += "自然村主键不能为空,";
        }

        if(StringUtils.isEmpty(naturalVillage.getNaturalVillageCode())){
            // 参数不完整 naturalVillageCode
            mess += "自然村编号不能为空,";
        }

        if(!StringUtils.isEmpty(naturalVillage.getNaturalVillageCode())){
            // 参数完整不重复
            NaturalVillage naturalVillageParam = new NaturalVillage();
            naturalVillageParam.setNaturalVillageCode(naturalVillage.getNaturalVillageCode());
            naturalVillageParam.setNaturalVillageId(naturalVillage.getNaturalVillageId());
            int count = naturalVillageService.checkOnlyUpdateNaturalVillageCode(naturalVillageParam);
            if(count > 0){
                // naturalVillageCode
                mess += "自然村编号有重复值,";
            }
        }
        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }

    @ApiOperation(value="修改自然村信息")
    @PostMapping("/updateNaturalVillageByPrimaryKeySelective")
    @ResponseBody
    public JSONResponse updateNaturalVillageByPrimaryKeySelective(HttpSession session, NaturalVillage naturalVillage){
        String mess = "";

        User user = (User) session.getAttribute("loginUser");
        if(naturalVillage.getNaturalVillageId() == null){
            // 参数不完整 naturalVillageId
            mess += "自然村主键不能为空,";
        }

        if(!StringUtils.isEmpty(naturalVillage.getNaturalVillageCode())){
            // 参数完整不重复
            NaturalVillage naturalVillageParam = new NaturalVillage();
            naturalVillageParam.setNaturalVillageId(naturalVillage.getNaturalVillageId());
            naturalVillageParam.setNaturalVillageCode(naturalVillage.getNaturalVillageCode());
            int count = naturalVillageService.checkOnlyUpdateNaturalVillageCode(naturalVillageParam);
            if(count > 0){
                // naturalVillageCode
                mess += "自然村编号有重复值,";
            }
        }

        // 经度不为空时
        if(!StringUtils.isEmpty(naturalVillage.getLongitude())){
            // 参数完整不重复
            Boolean flag = ValidatorUtil.isLongitude(naturalVillage.getLongitude());
            if(!flag){
                // longitude
                mess += "经度数值格式不正确,";
            }
        }

        // 纬度不为空时
        if(!StringUtils.isEmpty(naturalVillage.getLatitude())){
            // 参数完整不重复
            Boolean flag = ValidatorUtil.isLatitude(naturalVillage.getLatitude());
            if(!flag){
                // latitude
                mess += "纬度数值格式不正确,";
            }
        }

        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        if(user != null){
            naturalVillage.setCreateUserId(user.getId());
        }
        naturalVillage.setUpdateTime(DateUtil.getNow());

        naturalVillageService.updateByPrimaryKeySelective(naturalVillage);
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }

    @ApiOperation(value="根据主键获取自然村信息")
    @GetMapping("/selectByPrimaryKey")
    @ResponseBody
    public JSONResponse selectByPrimaryKey(Integer naturalVillageId){
        String mess = "";

        if(naturalVillageId == null){
            // 参数不完整 naturalVillageId
            mess += "自然村主键不能为空,";
        }

        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        NaturalVillage naturalVillage = naturalVillageService.selectByPrimaryKey(naturalVillageId);
        return ResponseUtils.success(ResSuccess.SYS_200, naturalVillage);
    }

    @ApiOperation(value="根据主键删除自然村信息")
    @PostMapping("/deleteByPrimaryKey")
    @ResponseBody
    public JSONResponse deleteByPrimaryKey(Integer naturalVillageId){
        String mess = "";

        if(naturalVillageId == null){
            // 参数不完整 naturalVillageId
            mess += "自然村主键不能为空,";
        }

        // 判断是不是有其他表的关联信息 @TODO


        if(!StringUtils.isEmpty(mess)){
            return ResponseUtils.error(SystemErrors.SYS_420.getCode(), mess.substring(0, mess.length()-1), null);
        }
        naturalVillageService.deleteByPrimaryKey(naturalVillageId);
        return ResponseUtils.success(ResSuccess.SYS_200, null);
    }


}
