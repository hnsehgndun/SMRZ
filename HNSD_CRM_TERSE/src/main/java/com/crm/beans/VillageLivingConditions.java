package com.crm.beans;

import java.io.Serializable;
import java.util.Date;

public class VillageLivingConditions implements Serializable {
    /**
     * 自然村生活条件信息表主键id
     */
    private Integer id;

    /**
     * 自然村基本信息表主键id
     */
    private Integer naturalVillageId;

    /**
     * 到乡镇距离
     */
    private Double distanceToTown;

    /**
     * 到乡镇是否通公路
     */
    private Boolean isConcreteRoadToTown;

    /**
     * 是否有公交
     */
    private Boolean isThereBus;

    /**
     * 未实现饮用水安全户数
     */
    private Integer totalUninstalledTapWater;

    /**
     * 危房户数
     */
    private Integer totalDangerousHouse;

    /**
     * 行政村图书室个数
     */
    private Integer totalLibrary;

    /**
     * 通宽带户数
     */
    private Integer totalUseInternet;

    /**
     * 行政村卫生室个数
     */
    private Integer totalBathroom;

    /**
     * 行政村公共卫生间个数
     */
    private Integer totalPublicToilet;

    /**
     * 行政村执业医生总数
     */
    private Integer totalDoctor;

    /**
     * 行政村垃圾堆放处总数
     */
    private Integer totalGarbageDump;

    /**
     * 行政村未通生活用电户数
     */
    private Integer totalNotDomesticElectricity;

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

    public Double getDistanceToTown() {
        return distanceToTown;
    }

    public void setDistanceToTown(Double distanceToTown) {
        this.distanceToTown = distanceToTown;
    }

    public Boolean getIsConcreteRoadToTown() {
        return isConcreteRoadToTown;
    }

    public void setIsConcreteRoadToTown(Boolean isConcreteRoadToTown) {
        this.isConcreteRoadToTown = isConcreteRoadToTown;
    }

    public Boolean getIsThereBus() {
        return isThereBus;
    }

    public void setIsThereBus(Boolean isThereBus) {
        this.isThereBus = isThereBus;
    }

    public Integer getTotalUninstalledTapWater() {
        return totalUninstalledTapWater;
    }

    public void setTotalUninstalledTapWater(Integer totalUninstalledTapWater) {
        this.totalUninstalledTapWater = totalUninstalledTapWater;
    }

    public Integer getTotalDangerousHouse() {
        return totalDangerousHouse;
    }

    public void setTotalDangerousHouse(Integer totalDangerousHouse) {
        this.totalDangerousHouse = totalDangerousHouse;
    }

    public Integer getTotalLibrary() {
        return totalLibrary;
    }

    public void setTotalLibrary(Integer totalLibrary) {
        this.totalLibrary = totalLibrary;
    }

    public Integer getTotalUseInternet() {
        return totalUseInternet;
    }

    public void setTotalUseInternet(Integer totalUseInternet) {
        this.totalUseInternet = totalUseInternet;
    }

    public Integer getTotalBathroom() {
        return totalBathroom;
    }

    public void setTotalBathroom(Integer totalBathroom) {
        this.totalBathroom = totalBathroom;
    }

    public Integer getTotalPublicToilet() {
        return totalPublicToilet;
    }

    public void setTotalPublicToilet(Integer totalPublicToilet) {
        this.totalPublicToilet = totalPublicToilet;
    }

    public Integer getTotalDoctor() {
        return totalDoctor;
    }

    public void setTotalDoctor(Integer totalDoctor) {
        this.totalDoctor = totalDoctor;
    }

    public Integer getTotalGarbageDump() {
        return totalGarbageDump;
    }

    public void setTotalGarbageDump(Integer totalGarbageDump) {
        this.totalGarbageDump = totalGarbageDump;
    }

    public Integer getTotalNotDomesticElectricity() {
        return totalNotDomesticElectricity;
    }

    public void setTotalNotDomesticElectricity(Integer totalNotDomesticElectricity) {
        this.totalNotDomesticElectricity = totalNotDomesticElectricity;
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
        sb.append(", distanceToTown=").append(distanceToTown);
        sb.append(", isConcreteRoadToTown=").append(isConcreteRoadToTown);
        sb.append(", isThereBus=").append(isThereBus);
        sb.append(", totalUninstalledTapWater=").append(totalUninstalledTapWater);
        sb.append(", totalDangerousHouse=").append(totalDangerousHouse);
        sb.append(", totalLibrary=").append(totalLibrary);
        sb.append(", totalUseInternet=").append(totalUseInternet);
        sb.append(", totalBathroom=").append(totalBathroom);
        sb.append(", totalPublicToilet=").append(totalPublicToilet);
        sb.append(", totalDoctor=").append(totalDoctor);
        sb.append(", totalGarbageDump=").append(totalGarbageDump);
        sb.append(", totalNotDomesticElectricity=").append(totalNotDomesticElectricity);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}