package com.crm.mapper;

import com.crm.beans.PoorFamilyAuditInfo;

public interface PoorFamilyAuditInfoMapper {
    int deleteByPrimaryKey(Integer pfaId);

    int insert(PoorFamilyAuditInfo record);

    int insertSelective(PoorFamilyAuditInfo record);

    PoorFamilyAuditInfo selectByPrimaryKey(Integer pfaId);

    int updateByPrimaryKeySelective(PoorFamilyAuditInfo record);

    int updateByPrimaryKey(PoorFamilyAuditInfo record);
}