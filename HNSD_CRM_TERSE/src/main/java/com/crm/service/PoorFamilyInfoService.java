package com.crm.service;


import com.crm.beans.PoorFamilyInfo;

import java.util.List;

/**
 * @author WKX
 */
public interface PoorFamilyInfoService {
    /**
     * 根据主键删除贫困户信息
     *
     * @param povertyId
     * @return
     */
    int deleteByPrimaryKey(Integer povertyId);

    /**
     * 插入贫困户信息，动态字段
     *
     * @param record
     * @return
     */
    int insertSelective(PoorFamilyInfo record);

    /**
     * 根据主键查询贫困户信息
     *
     * @param povertyId
     * @return
     */
    PoorFamilyInfo selectByPrimaryKey(Integer povertyId);

    /**
     * 更新贫困户信息,动态字段
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PoorFamilyInfo record);

    /**
     * 根据页码和每页条数，分页查询贫困户信息
     * @param page
     * @param pageSize
     * @return
     */
    List<PoorFamilyInfo> selectByPage(Integer page, Integer pageSize);

}
