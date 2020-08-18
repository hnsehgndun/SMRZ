package com.crm.mapper;


import com.crm.beans.PoorVillageAuditInfo;

public interface PoorVillageAuditInfoMapper {

    int deleteByPrimaryKey(Integer auditId);

    int insert(PoorVillageAuditInfo record);

    int insertSelective(PoorVillageAuditInfo record);

    PoorVillageAuditInfo selectByPrimaryKey(Integer auditId);

    int updateByPrimaryKeySelective(PoorVillageAuditInfo record);

    int updateByPrimaryKey(PoorVillageAuditInfo record);
}