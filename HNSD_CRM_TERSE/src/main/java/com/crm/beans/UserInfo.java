package com.crm.beans;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 */
public class UserInfo implements Serializable {
    //主键
    private int id;

    //用户姓名
    private String name;

    //身份证号
    private String idCard;

    //性别 0 女 1 男
    private int sex;

    //年纪
    private int age;

    //住址
    private String address;

    //邮编
    private int postCode;

    //标记
    private int sign;

    //权限 0 无权限
    private int power;

    //备注
    private String remarks;

    //创建时间
    @ApiModelProperty(hidden = true)
    private Date createTime;

    //修改时间
    @ApiModelProperty(hidden = true)
    private Date updateTime;

    //存放图片
    private String img;

    public UserInfo() {
    }

    public UserInfo(int id, String name, String idCard, int sex, int age, String address, int postCode, int sign, int power, String remarks, Date createTime, Date updateTime, String img) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.postCode = postCode;
        this.sign = sign;
        this.power = power;
        this.remarks = remarks;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", postCode=" + postCode +
                ", sign=" + sign +
                ", power=" + power +
                ", remarks='" + remarks + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", img='" + img + '\'' +
                '}';
    }
}
