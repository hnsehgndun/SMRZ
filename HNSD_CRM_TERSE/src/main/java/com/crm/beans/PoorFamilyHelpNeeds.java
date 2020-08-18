package com.crm.beans;

public class PoorFamilyHelpNeeds {
    private Integer pfnId;

    private Integer pfId;

    private String nType;

    private Integer nNum;

    private String unit;

    private String descr;

    public PoorFamilyHelpNeeds(Integer pfnId, Integer pfId, String nType, Integer nNum, String unit, String descr) {
        this.pfnId = pfnId;
        this.pfId = pfId;
        this.nType = nType;
        this.nNum = nNum;
        this.unit = unit;
        this.descr = descr;
    }

    public PoorFamilyHelpNeeds() {
        super();
    }

    public Integer getPfnId() {
        return pfnId;
    }

    public void setPfnId(Integer pfnId) {
        this.pfnId = pfnId;
    }

    public Integer getPfId() {
        return pfId;
    }

    public void setPfId(Integer pfId) {
        this.pfId = pfId;
    }

    public String getnType() {
        return nType;
    }

    public void setnType(String nType) {
        this.nType = nType == null ? null : nType.trim();
    }

    public Integer getnNum() {
        return nNum;
    }

    public void setnNum(Integer nNum) {
        this.nNum = nNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }
}