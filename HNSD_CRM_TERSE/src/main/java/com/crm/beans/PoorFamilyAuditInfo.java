package com.crm.beans;

import java.util.Date;

public class PoorFamilyAuditInfo {
    private Integer pfaId;

    private Integer pfId;

    private String auditType;

    private String auditStatus;

    private Integer createUserId;

    private Date createTime;

    private Integer updateUserId;

    private Date updateTime;

    private String auditContent;

    public PoorFamilyAuditInfo(Integer pfaId, Integer pfId, String auditType, String auditStatus, Integer createUserId, Date createTime, Integer updateUserId, Date updateTime, String auditContent) {
        this.pfaId = pfaId;
        this.pfId = pfId;
        this.auditType = auditType;
        this.auditStatus = auditStatus;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.updateUserId = updateUserId;
        this.updateTime = updateTime;
        this.auditContent = auditContent;
    }

    public PoorFamilyAuditInfo() {
        super();
    }

    public Integer getPfaId() {
        return pfaId;
    }

    public void setPfaId(Integer pfaId) {
        this.pfaId = pfaId;
    }

    public Integer getPfId() {
        return pfId;
    }

    public void setPfId(Integer pfId) {
        this.pfId = pfId;
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
}