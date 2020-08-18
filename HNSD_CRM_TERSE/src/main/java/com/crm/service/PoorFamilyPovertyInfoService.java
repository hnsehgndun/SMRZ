package com.crm.service;


import com.crm.beans.PoorFamilyPovertyInfo;
import com.crm.util.responseUtil.AjaxReturn;

/**
 * @author WKX
 */
public interface PoorFamilyPovertyInfoService {
    /**
     * 根据id删除贫困人信息
     * @param pId
     * @return
     */
    AjaxReturn deleteByPrimaryKey(Integer pId);

    /**
     * 添加贫困人信息
     * @param record
     * @return
     */
    AjaxReturn insert(PoorFamilyPovertyInfo record);

    /**
     * 添加贫困人信息，字段非空
     * @param record
     * @return
     */
    AjaxReturn insertSelective(PoorFamilyPovertyInfo record);

    /**
     * 根据id查询贫困人信息
     * @param pId
     * @return
     */
    AjaxReturn selectByPrimaryKey(Integer pId);

    /**
     * 更新贫困人信息，字段非空
     * @param record
     * @return
     */
    AjaxReturn updateByPrimaryKeySelective(PoorFamilyPovertyInfo record);

    /**
     * 更新贫困人信息
     * @param record
     * @return
     */
    AjaxReturn updateByPrimaryKey(PoorFamilyPovertyInfo record);
}
