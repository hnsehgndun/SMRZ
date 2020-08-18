package com.crm.mapper;

import com.crm.beans.VillageInSocialInsurance;

public interface VillageInSocialInsuranceMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(VillageInSocialInsurance record);

    int insertSelective(VillageInSocialInsurance record);

    VillageInSocialInsurance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VillageInSocialInsurance record);

    int updateByPrimaryKey(VillageInSocialInsurance record);
}