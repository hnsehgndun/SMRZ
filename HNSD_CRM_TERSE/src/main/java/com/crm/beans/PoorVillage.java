package com.crm.beans;

import java.util.Date;

public class PoorVillage {
    /**
     * 贫困村基本信息表主键id
     */
    private Integer villageId;

    /**
     * 所在县主键id
     */
    private Integer countyId;

    /**
     * 自然村基本信息表主键id
     */
    private Integer naturalVillageId;

    /**
     * 村负责人主键id
     */
    private Integer vAdminId;

    /**
     * 村属性，单选：0 贫困村，1 非贫困村，2 经济薄弱村
     */
    private Integer vProperty;

    /**
     * 发展方向属性，单选：0 中心村镇，1 一般村镇，2 过渡村镇
     */
    private Integer vDevelop;

    /**
     * 地形地貌属性，单选：0 山区， 1 丘陵，2 平坝
     */
    private Integer vTerrain;

    /**
     * 中共党员数，所选村发展中共党员数目
     */
    private Integer vPartyNum;

    /**
     * 村官人数，所选村发展村官人数
     */
    private Integer vOffice;

    /**
     * 扶贫状态
     */
    private Integer status;

    /**
     * 信息复审类型(0 季度审核, 1 年度审核)
     */
    private Integer reAudiSyle;

    /**
     * 信息复审状态, 审核状态，1：审核通过，0：审核未通过
     */
    private Integer reAuditStatus;

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

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public Integer getNaturalVillageId() {
        return naturalVillageId;
    }

    public void setNaturalVillageId(Integer naturalVillageId) {
        this.naturalVillageId = naturalVillageId;
    }

    public Integer getvAdminId() {
        return vAdminId;
    }

    public void setvAdminId(Integer vAdminId) {
        this.vAdminId = vAdminId;
    }

    public Integer getvProperty() {
        return vProperty;
    }

    public void setvProperty(Integer vProperty) {
        this.vProperty = vProperty;
    }

    public Integer getvDevelop() {
        return vDevelop;
    }

    public void setvDevelop(Integer vDevelop) {
        this.vDevelop = vDevelop;
    }

    public Integer getvTerrain() {
        return vTerrain;
    }

    public void setvTerrain(Integer vTerrain) {
        this.vTerrain = vTerrain;
    }

    public Integer getvPartyNum() {
        return vPartyNum;
    }

    public void setvPartyNum(Integer vPartyNum) {
        this.vPartyNum = vPartyNum;
    }

    public Integer getvOffice() {
        return vOffice;
    }

    public void setvOffice(Integer vOffice) {
        this.vOffice = vOffice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReAudiSyle() {
        return reAudiSyle;
    }

    public void setReAudiSyle(Integer reAudiSyle) {
        this.reAudiSyle = reAudiSyle;
    }

    public Integer getReAuditStatus() {
        return reAuditStatus;
    }

    public void setReAuditStatus(Integer reAuditStatus) {
        this.reAuditStatus = reAuditStatus;
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
}