package com.crm.controller;

import com.crm.beans.PoorFamilyPovertyInfo;
import com.crm.service.PoorFamilyPovertyInfoService;
import com.crm.util.responseUtil.AjaxReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author WKX
 */
@Api(value = "贫困户人口信息接口")
@RestController
public class PoorFamilyPovertyInfoController {
    @Autowired
    private PoorFamilyPovertyInfoService personInfoService;

    @ApiOperation(value = "根据id查询贫困户人口信息")
    @GetMapping("/selectPerSonInfo/{pId}")
    public AjaxReturn selectPersonInfo(@PathVariable("pId") Integer pId){
        return personInfoService.selectByPrimaryKey(pId);
    }

    @ApiOperation(value = "添加贫困户人口信息")
    @PostMapping("/addPersonInfo")
    public AjaxReturn addPersonInfo(@RequestBody PoorFamilyPovertyInfo personInfo){
        return personInfoService.insert(personInfo);
    }

    @ApiOperation(value ="更新贫困户人口信息")
    @PostMapping("/updatePersonInfo")
    public AjaxReturn updatePersonInfo(@RequestBody PoorFamilyPovertyInfo personInfo){
        return personInfoService.updateByPrimaryKey(personInfo);
    }





}
