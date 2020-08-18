package com.crm.mapper;

import com.crm.beans.PoorFamilyInfoDetail;

public interface PoorFamilyInfoDetailMapper {
    int deleteByPrimaryKey(Integer pfdId);

    int insert(PoorFamilyInfoDetail record);

    int insertSelective(PoorFamilyInfoDetail record);

    PoorFamilyInfoDetail selectByPrimaryKey(Integer pfdId);

    int updateByPrimaryKeySelective(PoorFamilyInfoDetail record);

    int updateByPrimaryKey(PoorFamilyInfoDetail record);
}