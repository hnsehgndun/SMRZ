package com.crm.beans;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class WorkAttendance implements Serializable {
    @ApiModelProperty(hidden = true)
    private Integer id;
    private Integer userId;
    private Integer workFlag;
    private Date workAttendanceTime;
    private Integer workMinute;
    private Integer delayTime;
    private String workDay;
    private String workDesc;

    public WorkAttendance() {
    }

    public WorkAttendance(Integer id, Integer userId, Integer workFlag, Date workAttendanceTime, Integer workMinute, Integer delayTime, String workDay, String workDesc) {
        this.id = id;
        this.userId = userId;
        this.workFlag = workFlag;
        this.workAttendanceTime = workAttendanceTime;
        this.workMinute = workMinute;
        this.delayTime = delayTime;
        this.workDay = workDay;
        this.workDesc = workDesc;
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

    public Integer getWorkFlag() {
        return workFlag;
    }

    public void setWorkFlag(Integer workFlag) {
        this.workFlag = workFlag;
    }

    public Date getWorkAttendanceTime() {
        return workAttendanceTime;
    }

    public void setWorkAttendanceTime(Date workAttendanceTime) {
        this.workAttendanceTime = workAttendanceTime;
    }

    public Integer getWorkMinute() {
        return workMinute;
    }

    public void setWorkMinute(Integer workMinute) {
        this.workMinute = workMinute;
    }

    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
    }

    public String getWorkDay() {
        return workDay;
    }

    public void setWorkDay(String workDay) {
        this.workDay = workDay;
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc;
    }

    @Override
    public String toString() {
        return "WorkAttendance{" +
                "id=" + id +
                ", userId=" + userId +
                ", workFlag=" + workFlag +
                ", workAttendanceTime=" + workAttendanceTime +
                ", workMinute=" + workMinute +
                ", delayTime=" + delayTime +
                ", workDay='" + workDay + '\'' +
                ", workDesc='" + workDesc + '\'' +
                '}';
    }
}
