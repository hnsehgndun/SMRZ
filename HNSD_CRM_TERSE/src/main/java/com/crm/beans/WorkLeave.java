package com.crm.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LCY
 * Date 2020/8/14
 */
public class WorkLeave implements Serializable {

    private static final long serialVersionUID = 7461429869270631993L;

    @ApiModelProperty(hidden = true)
    private Integer id;
    private Integer userId;
    private Integer leaveType;
    private Date leaveStarttime;
    private Date leaveEndtime;
    private String leaveDesc;
    @ApiModelProperty(hidden = true)
    private Integer leaveStatu;
    @ApiModelProperty(hidden = true)
    private Date leaveTime;


    public WorkLeave() {
    }

    public WorkLeave(Integer id, Integer userId, Integer leaveType, Date leaveStarttime, Date leaveEndtime, String leaveDesc, Integer leaveStatu,Date leaveTime) {
        this.id = id;
        this.userId = userId;
        this.leaveType = leaveType;
        this.leaveStarttime = leaveStarttime;
        this.leaveEndtime = leaveEndtime;
        this.leaveDesc = leaveDesc;
        this.leaveStatu = leaveStatu;
        this.leaveTime=leaveTime;
    }


    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(Integer leaveType) {
        this.leaveType = leaveType;
    }

    public Date getLeaveStarttime() {
        return leaveStarttime;
    }

    public void setLeaveStarttime(Date leaveStarttime) {
        this.leaveStarttime = leaveStarttime;
    }

    public Date getLeaveEndtime() {
        return leaveEndtime;
    }

    public void setLeaveEndtime(Date leaveEndtime) {
        this.leaveEndtime = leaveEndtime;
    }

    public String getLeaveDesc() {
        return leaveDesc;
    }

    public void setLeaveDesc(String leaveDesc) {
        this.leaveDesc = leaveDesc;
    }

    public Integer getLeaveStatu() {
        return leaveStatu;
    }

    public void setLeaveStatu(Integer leaveStatu) {
        this.leaveStatu = leaveStatu;
    }

    @Override
    public String toString() {
        return "WorkLeave{" +
                "id=" + id +
                ", userId=" + userId +
                ", leaveType=" + leaveType +
                ", leaveStarttime=" + leaveStarttime +
                ", leaveEndtime=" + leaveEndtime +
                ", leaveDesc='" + leaveDesc + '\'' +
                ", leaveStatu=" + leaveStatu +
                '}';
    }
}
