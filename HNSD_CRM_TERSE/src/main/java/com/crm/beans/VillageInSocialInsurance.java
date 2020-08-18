package com.crm.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 自然村参加社会保险信息表
 */
public class VillageInSocialInsurance implements Serializable {
    /**
     * 自然村参加社会保险信息表主键id
     */
    private Integer id;

    /**
     * 自然村基本信息表主键id
     */
    private Integer naturalVillageId;

    /**
     * 参加城乡居民医疗保险(新农合)人数
     */
    private Integer totalMedicalInsurance;

    /**
     * 参加城乡居民基本养老保险人数(新农保)
     */
    private Integer totalOldAgeInsurance;

    /**
     * 参加城镇职工基本养老保险人数
     */
    private Integer totalOldAgeWorkerInsurance;

    /**
     * 创建人
     */
    private Integer createUserId;

    /**
     * 更新人
     */
    private Integer updateUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNaturalVillageId() {
        return naturalVillageId;
    }

    public void setNaturalVillageId(Integer naturalVillageId) {
        this.naturalVillageId = naturalVillageId;
    }

    public Integer getTotalMedicalInsurance() {
        return totalMedicalInsurance;
    }

    public void setTotalMedicalInsurance(Integer totalMedicalInsurance) {
        this.totalMedicalInsurance = totalMedicalInsurance;
    }

    public Integer getTotalOldAgeInsurance() {
        return totalOldAgeInsurance;
    }

    public void setTotalOldAgeInsurance(Integer totalOldAgeInsurance) {
        this.totalOldAgeInsurance = totalOldAgeInsurance;
    }

    public Integer getTotalOldAgeWorkerInsurance() {
        return totalOldAgeWorkerInsurance;
    }

    public void setTotalOldAgeWorkerInsurance(Integer totalOldAgeWorkerInsurance) {
        this.totalOldAgeWorkerInsurance = totalOldAgeWorkerInsurance;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", naturalVillageId=").append(naturalVillageId);
        sb.append(", totalMedicalInsurance=").append(totalMedicalInsurance);
        sb.append(", totalOldAgeInsurance=").append(totalOldAgeInsurance);
        sb.append(", totalOldAgeWorkerInsurance=").append(totalOldAgeWorkerInsurance);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}