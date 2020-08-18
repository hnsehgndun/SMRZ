package com.crm.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 所在地地址信息表
 */
public class LocationAddress implements Serializable {

    /**
     * 所在地地址信息表主键id
     */
    private Integer locationId;

    /**
     * 关联记录的主键id
     */
    private Integer associateId;

    /**
     * 所在省id
     */
    private Integer provinceId;

    /**
     * 所在省名称
     */
    private String provinceName;

    /**
     * 所在省编码
     */
    private String provinceCode;

    /**
     * 所在市id
     */
    private Integer cityId;

    /**
     * 所在市名称
     */
    private String cityName;

    /**
     * 所在市编码
     */
    private String cityCode;

    /**
     * 所在县id
     */
    private Integer countyId;

    /**
     * 所在县名称
     */
    private Integer countyName;

    /**
     * 所在县编码
     */
    private Integer countyCode;

    /**
     * 详细地址
     */
    private String detailAddress;

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

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getAssociateId() {
        return associateId;
    }

    public void setAssociateId(Integer associateId) {
        this.associateId = associateId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public Integer getCountyName() {
        return countyName;
    }

    public void setCountyName(Integer countyName) {
        this.countyName = countyName;
    }

    public Integer getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(Integer countyCode) {
        this.countyCode = countyCode;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
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
        sb.append(", locationId=").append(locationId);
        sb.append(", associateId=").append(associateId);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", cityId=").append(cityId);
        sb.append(", cityName=").append(cityName);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", countyId=").append(countyId);
        sb.append(", countyName=").append(countyName);
        sb.append(", countyCode=").append(countyCode);
        sb.append(", detailAddress=").append(detailAddress);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}