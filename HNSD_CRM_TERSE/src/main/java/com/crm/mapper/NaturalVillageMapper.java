package com.crm.mapper;

import com.crm.beans.NaturalVillage;
import com.crm.util.responseUtil.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NaturalVillageMapper {

    int deleteByPrimaryKey(Integer naturalVillageId);

    int insert(NaturalVillage record);

    int insertSelective(NaturalVillage record);

    NaturalVillage selectByPrimaryKey(Integer naturalVillageId);

    int updateByPrimaryKeySelective(NaturalVillage record);

    int updateByPrimaryKey(NaturalVillage record);

    List<NaturalVillage> getNaturalVillageList(@Param("naturalVillage") NaturalVillage naturalVillage, @Param("page") PageBean page);

    int getNaturalVillageListCount(@Param("naturalVillage") NaturalVillage naturalVillage);

    int checkOnlyUpdateNaturalVillageCode(@Param("naturalVillage") NaturalVillage naturalVillage);

}