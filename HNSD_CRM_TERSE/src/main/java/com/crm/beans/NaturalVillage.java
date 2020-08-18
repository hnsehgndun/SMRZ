package com.crm.beans;

import java.util.Date;

public class NaturalVillage {
    /**
     * 自然村基本信息表主键id
     */
    private Integer naturalVillageId;

    /**
     * 自然村编号
     */
    private String naturalVillageCode;

    /**
     * 自然村名称
     */
    private String naturalVillageName;

    /**
     * 自然村地址
     */
    private Integer naturalVillageAddress;

    /**
     * 自然村总户数
     */
    private Integer totalHousehold;

    /**
     * 自然村总人数
     */
    private Integer totalPopulation;

    /**
     * 是否通公路
     */
    private Boolean isConcreteRoad;

    /**
     * 是否使用生活用电
     */
    private Boolean isDomesticElectricity;

    /**
     * 是否通宽带
     */
    private Boolean isUseInternet;

    /**
     * 贫困户数
     */
    private Integer totalPoorHousehold;

    /**
     * 低保户数
     */
    private Integer totalLowIncomeFamily;

    /**
     * 五保户数
     */
    private Integer totalInsuredHousehold;

    /**
     * 村负责人主键id(村长)
     */
    private Integer villageChiefId;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

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


    public Integer getNaturalVillageId() {
        return naturalVillageId;
    }


    public void setNaturalVillageId(Integer naturalVillageId) {
        this.naturalVillageId = naturalVillageId;
    }


    public String getNaturalVillageCode() {
        return naturalVillageCode;
    }


    public void setNaturalVillageCode(String naturalVillageCode) {
        this.naturalVillageCode = naturalVillageCode == null ? null : naturalVillageCode.trim();
    }


    public String getNaturalVillageName() {
        return naturalVillageName;
    }


    public void setNaturalVillageName(String naturalVillageName) {
        this.naturalVillageName = naturalVillageName == null ? null : naturalVillageName.trim();
    }


    public Integer getNaturalVillageAddress() {
        return naturalVillageAddress;
    }


    public void setNaturalVillageAddress(Integer naturalVillageAddress) {
        this.naturalVillageAddress = naturalVillageAddress;
    }


    public Integer getTotalHousehold() {
        return totalHousehold;
    }


    public void setTotalHousehold(Integer totalHousehold) {
        this.totalHousehold = totalHousehold;
    }


    public Integer getTotalPopulation() {
        return totalPopulation;
    }


    public void setTotalPopulation(Integer totalPopulation) {
        this.totalPopulation = totalPopulation;
    }


    public Boolean getIsConcreteRoad() {
        return isConcreteRoad;
    }


    public void setIsConcreteRoad(Boolean isConcreteRoad) {
        this.isConcreteRoad = isConcreteRoad;
    }


    public Boolean getIsDomesticElectricity() {
        return isDomesticElectricity;
    }


    public void setIsDomesticElectricity(Boolean isDomesticElectricity) {
        this.isDomesticElectricity = isDomesticElectricity;
    }


    public Boolean getIsUseInternet() {
        return isUseInternet;
    }


    public void setIsUseInternet(Boolean isUseInternet) {
        this.isUseInternet = isUseInternet;
    }


    public Integer getTotalPoorHousehold() {
        return totalPoorHousehold;
    }


    public void setTotalPoorHousehold(Integer totalPoorHousehold) {
        this.totalPoorHousehold = totalPoorHousehold;
    }


    public Integer getTotalLowIncomeFamily() {
        return totalLowIncomeFamily;
    }


    public void setTotalLowIncomeFamily(Integer totalLowIncomeFamily) {
        this.totalLowIncomeFamily = totalLowIncomeFamily;
    }

    public Integer getTotalInsuredHousehold() {
        return totalInsuredHousehold;
    }

    public void setTotalInsuredHousehold(Integer totalInsuredHousehold) {
        this.totalInsuredHousehold = totalInsuredHousehold;
    }

    public Integer getVillageChiefId() {
        return villageChiefId;
    }

    public void setVillageChiefId(Integer villageChiefId) {
        this.villageChiefId = villageChiefId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
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