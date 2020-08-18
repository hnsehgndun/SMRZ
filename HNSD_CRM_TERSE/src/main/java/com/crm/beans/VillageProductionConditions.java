package com.crm.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VillageProductionConditions implements Serializable {
    /**
     * 自然村生产条件信息表主键id
     */
    private Integer id;

    /**
     * 自然村基本信息表主键id
     */
    private Integer naturalVillageId;

    /**
     * 耕地面积
     */
    private BigDecimal totalCultivatedLand;

    /**
     * 有效耕地面积
     */
    private BigDecimal availableCultivatedLand;

    /**
     * 林地面积
     */
    private BigDecimal totalWoodland;

    /**
     * 退耕还林面积
     */
    private BigDecimal farmlandToForest;

    /**
     * 林果面积
     */
    private BigDecimal totalFruitLand;

    /**
     * 牧草面积
     */
    private BigDecimal totalHerbageLand;

    /**
     * 水域面积
     */
    private BigDecimal totalWaterArea;

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

    public BigDecimal getTotalCultivatedLand() {
        return totalCultivatedLand;
    }

    public void setTotalCultivatedLand(BigDecimal totalCultivatedLand) {
        this.totalCultivatedLand = totalCultivatedLand;
    }

    public BigDecimal getAvailableCultivatedLand() {
        return availableCultivatedLand;
    }

    public void setAvailableCultivatedLand(BigDecimal availableCultivatedLand) {
        this.availableCultivatedLand = availableCultivatedLand;
    }

    public BigDecimal getTotalWoodland() {
        return totalWoodland;
    }

    public void setTotalWoodland(BigDecimal totalWoodland) {
        this.totalWoodland = totalWoodland;
    }

    public BigDecimal getFarmlandToForest() {
        return farmlandToForest;
    }

    public void setFarmlandToForest(BigDecimal farmlandToForest) {
        this.farmlandToForest = farmlandToForest;
    }

    public BigDecimal getTotalFruitLand() {
        return totalFruitLand;
    }

    public void setTotalFruitLand(BigDecimal totalFruitLand) {
        this.totalFruitLand = totalFruitLand;
    }

    public BigDecimal getTotalHerbageLand() {
        return totalHerbageLand;
    }

    public void setTotalHerbageLand(BigDecimal totalHerbageLand) {
        this.totalHerbageLand = totalHerbageLand;
    }

    public BigDecimal getTotalWaterArea() {
        return totalWaterArea;
    }

    public void setTotalWaterArea(BigDecimal totalWaterArea) {
        this.totalWaterArea = totalWaterArea;
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
        sb.append(", totalCultivatedLand=").append(totalCultivatedLand);
        sb.append(", availableCultivatedLand=").append(availableCultivatedLand);
        sb.append(", totalWoodland=").append(totalWoodland);
        sb.append(", farmlandToForest=").append(farmlandToForest);
        sb.append(", totalFruitLand=").append(totalFruitLand);
        sb.append(", totalHerbageLand=").append(totalHerbageLand);
        sb.append(", totalWaterArea=").append(totalWaterArea);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}