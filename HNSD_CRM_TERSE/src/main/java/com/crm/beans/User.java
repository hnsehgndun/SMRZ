package com.crm.beans;

import java.io.Serializable;


public class User implements Serializable {
    private static final long serialVersionUID = -8518464645376128784L;
    private Integer id;
    private String username;
    private String password;
    private String uphone;
    private Integer userinfoId;

    public User() {
    }

    public User(Integer id, String username, String password, String uphone, Integer userinfoId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.uphone = uphone;
        this.userinfoId = userinfoId;
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

    public Integer getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(Integer userinfoId) {
        this.userinfoId = userinfoId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uphone='" + uphone + '\'' +
                ", userinfoId=" + userinfoId +
                '}';
    }
}
