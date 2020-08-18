package com.crm.beans;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -3678836526687916977L;
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

    //身份证正面
    private String imgObverse;

    //身份证背面
    private String imgReverse;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setImgObverse(String imgObverse) {
        this.imgObverse = imgObverse;
    }

    public void setImgReverse(String imgReverse) {
        this.imgReverse = imgReverse;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdCard() {
        return idCard;
    }

    public int getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getPostCode() {
        return postCode;
    }

    public int getSign() {
        return sign;
    }

    public int getPower() {
        return power;
    }

    public String getRemarks() {
        return remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getImgObverse() {
        return imgObverse;
    }

    public String getImgReverse() {
        return imgReverse;
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
                ", imgObverse='" + imgObverse + '\'' +
                ", imgReverse='" + imgReverse + '\'' +
                '}';
    }
}
