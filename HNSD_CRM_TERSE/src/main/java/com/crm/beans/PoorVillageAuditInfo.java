package com.crm.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 贫困村复审信息表
 */
public class PoorVillageAuditInfo implements Serializable {
    /**
     * 编号
     */
    private Integer auditId;

    /**
     * 贫困村基本信息表主键id
     */
    private Integer villageId;

    /**
     * 审核类型，0: 季度审核；1: 年度审核
     */
    private String auditType;

    /**
     * 审核状态，1：审核通过，0：审核未通过
     */
    private String auditStatus;

    /**
     * 创建人/审核人
     */
    private Integer createUserId;

    /**
     * 创建时间/审核时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Integer updateUserId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 审核说明
     */
    private String auditContent;

    private static final long serialVersionUID = 1L;

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType == null ? null : auditType.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAuditContent() {
        return auditContent;
    }

    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent == null ? null : auditContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", auditId=").append(auditId);
        sb.append(", villageId=").append(villageId);
        sb.append(", auditType=").append(auditType);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", auditContent=").append(auditContent);
        sb.append("]");
        return sb.toString();
    }
}