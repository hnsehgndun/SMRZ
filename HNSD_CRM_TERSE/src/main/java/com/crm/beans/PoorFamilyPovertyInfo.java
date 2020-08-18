package com.crm.beans;

public class PoorFamilyPovertyInfo {
    private Integer pfiId;

    private Integer pfId;

    private String name;

    private String sex;

    private String docType;

    private String docId;

    private String password;

    private String birth;

    private String relation;

    private String nation;

    private String eduLevel;

    private String stuStatus;

    private String skills;

    private String empStaus;

    private String worHours;

    private String health;

    private String serviceman;

    private String survival;

    public PoorFamilyPovertyInfo(Integer pfiId, Integer pfId, String name, String sex, String docType, String docId, String password, String birth, String relation, String nation, String eduLevel, String stuStatus, String skills, String empStaus, String worHours, String health, String serviceman, String survival) {
        this.pfiId = pfiId;
        this.pfId = pfId;
        this.name = name;
        this.sex = sex;
        this.docType = docType;
        this.docId = docId;
        this.password = password;
        this.birth = birth;
        this.relation = relation;
        this.nation = nation;
        this.eduLevel = eduLevel;
        this.stuStatus = stuStatus;
        this.skills = skills;
        this.empStaus = empStaus;
        this.worHours = worHours;
        this.health = health;
        this.serviceman = serviceman;
        this.survival = survival;
    }

    public PoorFamilyPovertyInfo() {
        super();
    }

    public Integer getPfiId() {
        return pfiId;
    }

    public void setPfiId(Integer pfiId) {
        this.pfiId = pfiId;
    }

    public Integer getPfId() {
        return pfId;
    }

    public void setPfId(Integer pfId) {
        this.pfId = pfId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType == null ? null : docType.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel == null ? null : eduLevel.trim();
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus == null ? null : stuStatus.trim();
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills == null ? null : skills.trim();
    }

    public String getEmpStaus() {
        return empStaus;
    }

    public void setEmpStaus(String empStaus) {
        this.empStaus = empStaus == null ? null : empStaus.trim();
    }

    public String getWorHours() {
        return worHours;
    }

    public void setWorHours(String worHours) {
        this.worHours = worHours == null ? null : worHours.trim();
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health == null ? null : health.trim();
    }

    public String getServiceman() {
        return serviceman;
    }

    public void setServiceman(String serviceman) {
        this.serviceman = serviceman == null ? null : serviceman.trim();
    }

    public String getSurvival() {
        return survival;
    }

    public void setSurvival(String survival) {
        this.survival = survival == null ? null : survival.trim();
    }
}