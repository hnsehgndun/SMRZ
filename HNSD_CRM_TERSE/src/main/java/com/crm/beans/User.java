package com.crm.beans;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String uphone;
    private Integer realnameFlag;

    public User() {
    }

    public User(Integer id, String username, String password, String uphone, Integer realnameFlag) {
        this.id = id;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uphone='" + uphone + '\'' +
                ", realnameFlag=" + realnameFlag +
                '}';
    }
}
