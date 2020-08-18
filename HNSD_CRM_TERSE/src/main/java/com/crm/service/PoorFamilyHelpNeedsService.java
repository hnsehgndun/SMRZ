package com.crm.service;


import com.crm.beans.PoorFamilyHelpNeeds;

/**
 * @author WKX
 */
public interface PoorFamilyHelpNeedsService {

    int deleteByPrimaryKey(Integer nId);

    int insert(PoorFamilyHelpNeeds record);

    int insertSelective(PoorFamilyHelpNeeds record);

    PoorFamilyHelpNeeds selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(PoorFamilyHelpNeeds record);

    int updateByPrimaryKey(PoorFamilyHelpNeeds record);
}
