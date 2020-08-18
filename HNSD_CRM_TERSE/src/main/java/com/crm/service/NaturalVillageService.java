package com.crm.service;

import com.crm.beans.NaturalVillage;
import com.crm.util.responseUtil.PageBean;

public interface NaturalVillageService {

    PageBean<NaturalVillage> getNaturalVillageList(NaturalVillage naturalVillage, PageBean page);

    int insertSelective(NaturalVillage naturalVillage);

    NaturalVillage selectByPrimaryKey(Integer naturalVillageId);

    int updateByPrimaryKeySelective(NaturalVillage record);

    /**
     * 判断是否为唯一的自然村编码
     */
    int checkOnlyNaturalVillage(NaturalVillage naturalVillage);

    /**
     * 验证更新时自然村信息是否重复
     */
    int checkOnlyUpdateNaturalVillageCode(NaturalVillage naturalVillage);

    int deleteByPrimaryKey(Integer naturalVillageId);



}
