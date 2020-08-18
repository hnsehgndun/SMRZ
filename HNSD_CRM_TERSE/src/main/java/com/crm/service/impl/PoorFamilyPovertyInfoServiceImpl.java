package com.crm.service.impl;

import com.crm.beans.PoorFamilyPovertyInfo;
import com.crm.mapper.PoorFamilyPovertyInfoMapper;
import com.crm.service.PoorFamilyPovertyInfoService;
import com.crm.util.responseUtil.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WKX
 */
@Service
public class PoorFamilyPovertyInfoServiceImpl implements PoorFamilyPovertyInfoService {
    @Autowired
    private PoorFamilyPovertyInfoMapper poorFamilyPovertyInfoMapper;
    @Override
    public AjaxReturn deleteByPrimaryKey(Integer pId) {
        int i = poorFamilyPovertyInfoMapper.deleteByPrimaryKey(pId);
        if (i==1){
            return AjaxReturn.success();
        }else {
            return AjaxReturn.error();
        }
    }

    @Override
    public AjaxReturn insert(PoorFamilyPovertyInfo record) {
        int i = poorFamilyPovertyInfoMapper.insert(record);
        if (i==1){
            return AjaxReturn.success();
        }else{
            return AjaxReturn.error();
        }
    }

    @Override
    public AjaxReturn insertSelective(PoorFamilyPovertyInfo record) {
        int i = poorFamilyPovertyInfoMapper.insertSelective(record);
        if (i==1){
            return AjaxReturn.success();
        }else {
            return AjaxReturn.error();
        }
    }

    @Override
    public AjaxReturn selectByPrimaryKey(Integer pId) {
        PoorFamilyPovertyInfo personInfo = poorFamilyPovertyInfoMapper.selectByPrimaryKey(pId);
        return AjaxReturn.success().put("data",personInfo);

    }

    @Override
    public AjaxReturn updateByPrimaryKeySelective(PoorFamilyPovertyInfo record) {
        int i = poorFamilyPovertyInfoMapper.updateByPrimaryKeySelective(record);
        if(i==1){
            return AjaxReturn.success();
        }else{
            return AjaxReturn.error();
        }
    }

    @Override
    public AjaxReturn updateByPrimaryKey(PoorFamilyPovertyInfo record) {
        int i = poorFamilyPovertyInfoMapper.updateByPrimaryKey(record);
        if(i==1){
            return AjaxReturn.success();
        }else {
            return AjaxReturn.error();
        }
    }
}
