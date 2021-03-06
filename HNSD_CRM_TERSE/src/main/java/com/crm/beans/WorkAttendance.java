package com.crm.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class WorkAttendance implements Serializable {
    private static final long serialVersionUID = 1375030762489891236L;
    private Integer id;
    private Integer userId;
    private Integer workFlag;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date workAttendanceTime;
    private Integer workMinute;
    private Integer delayTime;
    private String workDay;
    private String workDesc;
    private String uphone;

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

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
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
