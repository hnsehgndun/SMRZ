package com.crm.beans;

public class PoorFamilyInfo {
    private Integer pfId;

    private Integer townId;

    private String holderName;

    private String holderTel;

    private String pfBankArea;

    private String pfBankNum;

    private String pfStandard;

    private String pfProperty;

    private String pfReason;

    private String pfStatus;

    public PoorFamilyInfo(Integer pfId, Integer townId, String holderName, String holderTel, String pfBankArea, String pfBankNum, String pfStandard, String pfProperty, String pfReason, String pfStatus) {
        this.pfId = pfId;
        this.townId = townId;
        this.holderName = holderName;
        this.holderTel = holderTel;
        this.pfBankArea = pfBankArea;
        this.pfBankNum = pfBankNum;
        this.pfStandard = pfStandard;
        this.pfProperty = pfProperty;
        this.pfReason = pfReason;
        this.pfStatus = pfStatus;
    }

    public PoorFamilyInfo() {
        super();
    }

    public Integer getPfId() {
        return pfId;
    }

    public void setPfId(Integer pfId) {
        this.pfId = pfId;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName == null ? null : holderName.trim();
    }

    public String getHolderTel() {
        return holderTel;
    }

    public void setHolderTel(String holderTel) {
        this.holderTel = holderTel == null ? null : holderTel.trim();
    }

    public String getPfBankArea() {
        return pfBankArea;
    }

    public void setPfBankArea(String pfBankArea) {
        this.pfBankArea = pfBankArea == null ? null : pfBankArea.trim();
    }

    public String getPfBankNum() {
        return pfBankNum;
    }

    public void setPfBankNum(String pfBankNum) {
        this.pfBankNum = pfBankNum == null ? null : pfBankNum.trim();
    }

    public String getPfStandard() {
        return pfStandard;
    }

    public void setPfStandard(String pfStandard) {
        this.pfStandard = pfStandard == null ? null : pfStandard.trim();
    }

    public String getPfProperty() {
        return pfProperty;
    }

    public void setPfProperty(String pfProperty) {
        this.pfProperty = pfProperty == null ? null : pfProperty.trim();
    }

    public String getPfReason() {
        return pfReason;
    }

    public void setPfReason(String pfReason) {
        this.pfReason = pfReason == null ? null : pfReason.trim();
    }

    public String getPfStatus() {
        return pfStatus;
    }

    public void setPfStatus(String pfStatus) {
        this.pfStatus = pfStatus == null ? null : pfStatus.trim();
    }
}