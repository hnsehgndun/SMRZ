package com.crm.beans;

import java.math.BigDecimal;

public class PoorFamilyInfoDetail {
    private Integer pfdId;

    private Integer pfId;

    private BigDecimal wageInco;

    private BigDecimal productInco;

    private BigDecimal propertyInco;

    private BigDecimal otherInco;

    private BigDecimal annualInco;

    private BigDecimal productExp;

    private BigDecimal otherExp;

    private BigDecimal netInco;

    private BigDecimal perInco;

    private BigDecimal tillArea;

    private String electricity;

    private String farmerCooper;

    private String airingTele;

    private BigDecimal houseArea;

    private String dangerHouse;

    private String dangerLevel;

    private String toilet;

    private String fuelType;

    public PoorFamilyInfoDetail(Integer pfdId, Integer pfId, BigDecimal wageInco, BigDecimal productInco, BigDecimal propertyInco, BigDecimal otherInco, BigDecimal annualInco, BigDecimal productExp, BigDecimal otherExp, BigDecimal netInco, BigDecimal perInco, BigDecimal tillArea, String electricity, String farmerCooper, String airingTele, BigDecimal houseArea, String dangerHouse, String dangerLevel, String toilet, String fuelType) {
        this.pfdId = pfdId;
        this.pfId = pfId;
        this.wageInco = wageInco;
        this.productInco = productInco;
        this.propertyInco = propertyInco;
        this.otherInco = otherInco;
        this.annualInco = annualInco;
        this.productExp = productExp;
        this.otherExp = otherExp;
        this.netInco = netInco;
        this.perInco = perInco;
        this.tillArea = tillArea;
        this.electricity = electricity;
        this.farmerCooper = farmerCooper;
        this.airingTele = airingTele;
        this.houseArea = houseArea;
        this.dangerHouse = dangerHouse;
        this.dangerLevel = dangerLevel;
        this.toilet = toilet;
        this.fuelType = fuelType;
    }

    public PoorFamilyInfoDetail() {
        super();
    }

    public Integer getPfdId() {
        return pfdId;
    }

    public void setPfdId(Integer pfdId) {
        this.pfdId = pfdId;
    }

    public Integer getPfId() {
        return pfId;
    }

    public void setPfId(Integer pfId) {
        this.pfId = pfId;
    }

    public BigDecimal getWageInco() {
        return wageInco;
    }

    public void setWageInco(BigDecimal wageInco) {
        this.wageInco = wageInco;
    }

    public BigDecimal getProductInco() {
        return productInco;
    }

    public void setProductInco(BigDecimal productInco) {
        this.productInco = productInco;
    }

    public BigDecimal getPropertyInco() {
        return propertyInco;
    }

    public void setPropertyInco(BigDecimal propertyInco) {
        this.propertyInco = propertyInco;
    }

    public BigDecimal getOtherInco() {
        return otherInco;
    }

    public void setOtherInco(BigDecimal otherInco) {
        this.otherInco = otherInco;
    }

    public BigDecimal getAnnualInco() {
        return annualInco;
    }

    public void setAnnualInco(BigDecimal annualInco) {
        this.annualInco = annualInco;
    }

    public BigDecimal getProductExp() {
        return productExp;
    }

    public void setProductExp(BigDecimal productExp) {
        this.productExp = productExp;
    }

    public BigDecimal getOtherExp() {
        return otherExp;
    }

    public void setOtherExp(BigDecimal otherExp) {
        this.otherExp = otherExp;
    }

    public BigDecimal getNetInco() {
        return netInco;
    }

    public void setNetInco(BigDecimal netInco) {
        this.netInco = netInco;
    }

    public BigDecimal getPerInco() {
        return perInco;
    }

    public void setPerInco(BigDecimal perInco) {
        this.perInco = perInco;
    }

    public BigDecimal getTillArea() {
        return tillArea;
    }

    public void setTillArea(BigDecimal tillArea) {
        this.tillArea = tillArea;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity == null ? null : electricity.trim();
    }

    public String getFarmerCooper() {
        return farmerCooper;
    }

    public void setFarmerCooper(String farmerCooper) {
        this.farmerCooper = farmerCooper == null ? null : farmerCooper.trim();
    }

    public String getAiringTele() {
        return airingTele;
    }

    public void setAiringTele(String airingTele) {
        this.airingTele = airingTele == null ? null : airingTele.trim();
    }

    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
    }

    public String getDangerHouse() {
        return dangerHouse;
    }

    public void setDangerHouse(String dangerHouse) {
        this.dangerHouse = dangerHouse == null ? null : dangerHouse.trim();
    }

    public String getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel == null ? null : dangerLevel.trim();
    }

    public String getToilet() {
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet == null ? null : toilet.trim();
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType == null ? null : fuelType.trim();
    }
}