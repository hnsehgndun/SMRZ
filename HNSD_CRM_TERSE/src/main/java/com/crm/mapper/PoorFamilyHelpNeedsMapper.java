package com.crm.mapper;

import com.crm.beans.PoorFamilyHelpNeeds;

public interface PoorFamilyHelpNeedsMapper {
    int deleteByPrimaryKey(Integer pfnId);

    int insert(PoorFamilyHelpNeeds record);

    int insertSelective(PoorFamilyHelpNeeds record);

    PoorFamilyHelpNeeds selectByPrimaryKey(Integer pfnId);

    int updateByPrimaryKeySelective(PoorFamilyHelpNeeds record);

    int updateByPrimaryKey(PoorFamilyHelpNeeds record);
}