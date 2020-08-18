package com.crm.mapper;

import com.crm.beans.PoorFamilyPovertyInfo;

public interface PoorFamilyPovertyInfoMapper {
    int deleteByPrimaryKey(Integer pfiId);

    int insert(PoorFamilyPovertyInfo record);

    int insertSelective(PoorFamilyPovertyInfo record);

    PoorFamilyPovertyInfo selectByPrimaryKey(Integer pfiId);

    int updateByPrimaryKeySelective(PoorFamilyPovertyInfo record);

    int updateByPrimaryKey(PoorFamilyPovertyInfo record);
}