package com.crm.beans;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


public class User implements Serializable {
    @ApiModelProperty(hidden = true)
    private Integer id;
    private String uid;
    private String password;
    private String uphone;

    @ApiModelProperty(hidden = true)
    private Integer realnameFlag;
    //临时变量  验证码
    @ApiModelProperty(hidden = true)
    private String randomcode;

    public User() {
    }

    public User(Integer id, String uid, String password, String uphone, Integer realnameFlag) {
        this.id = id;
        this.uid = uid;
        this.password = password;
        this.uphone = uphone;
        this.realnameFlag = realnameFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public Integer getRealnameFlag() {
        return realnameFlag;
    }

    public void setRealnameFlag(Integer realnameFlag) {
        this.realnameFlag = realnameFlag;
    }

    public String getRandomcode() {
        return randomcode;
    }

    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", password='" + password + '\'' +
                ", uphone='" + uphone + '\'' +
                ", realnameFlag=" + realnameFlag +
                '}';
    }
}
