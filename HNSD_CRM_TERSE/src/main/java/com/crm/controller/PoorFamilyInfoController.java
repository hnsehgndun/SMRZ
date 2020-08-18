package com.crm.controller;

import com.crm.beans.PoorFamilyInfo;
import com.crm.service.PoorFamilyInfoService;
import com.crm.util.responseUtil.AjaxReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WKX
 */
@Api(value = "贫困户信息接口")
@RestController
public class PoorFamilyInfoController {
    @Autowired
    private PoorFamilyInfoService povertyInfoService;

    @ApiOperation(value = "根据编号查询贫困户信息")
    @GetMapping("/selectPovertyById/{povertyId}")
    public AjaxReturn selectPovertyById(@PathVariable("povertyId") Integer povertyId) {
        return AjaxReturn.success().put("data", povertyInfoService.selectByPrimaryKey(povertyId));
    }

    @ApiOperation(value = "添加贫困户信息")
    @PostMapping("/addPoverty")
    public AjaxReturn addPoverty(PoorFamilyInfo povertyInfo) {
        if (povertyInfoService.insertSelective(povertyInfo) == 1) {
            return AjaxReturn.success();
        } else {
            return AjaxReturn.error();
        }
    }

    @ApiOperation(value = "更新贫困户信息")
    @PostMapping("/updatePovertyInfo")
    public AjaxReturn updatePovertyInfo(PoorFamilyInfo povertyInfo) {
        if (povertyInfoService.updateByPrimaryKeySelective(povertyInfo) == 1) {
            return AjaxReturn.success();
        } else {
            return AjaxReturn.error();
        }
    }

    @ApiOperation(value = "根据编号删除贫困户信息")
    @PostMapping("/deletePovertyInfoById/{povertyId}")
    public AjaxReturn deletePovertyInfoById(@PathVariable("povertyId") Integer povertyId) {
        if (povertyInfoService.deleteByPrimaryKey(povertyId) == 1) {
            return AjaxReturn.success();
        } else {
            return AjaxReturn.error();
        }
    }

    @ApiOperation(value = "分页查询贫困户信息")
    @PostMapping("/selectPovertyByPage/{page}/{pageSize}")
    public AjaxReturn selectPovertyByPage(@PathVariable("page") Integer page,@PathVariable("pageSize") Integer pageSize) {
        return AjaxReturn.success().put("data",povertyInfoService.selectByPage(page, pageSize));
    }

    

}
