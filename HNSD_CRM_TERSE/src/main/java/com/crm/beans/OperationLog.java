package com.crm.beans;

import java.io.Serializable;
import java.util.Date;

public class OperationLog implements Serializable {
    //uuid 唯一
    private String id;
     //日志等级(可根据具体业务方法自定义等级)
    private Integer level;
    //被操作的对象
    private String operationUnit;
    //方法名
    private String method;
    //参数
    private String args;
    //操作人账号id
    private String uid;
    //日志描述
    private String describe;
    //操作类型
    private String operationType;
    //方法运行时间
    private Integer runTime;
    //方法返回值
    private String returnValue;
    //操作时间
    private Date operationDate;

    public OperationLog() {
    }

    public OperationLog(String id, Integer level, String operationUnit, String method, String args, String uid, String describe, String operationType, Integer runTime, String returnValue, Date operationDate) {
        this.id = id;
        this.level = level;
        this.operationUnit = operationUnit;
        this.method = method;
        this.args = args;
        this.uid = uid;
        this.describe = describe;
        this.operationType = operationType;
        this.runTime = runTime;
        this.returnValue = returnValue;
        this.operationDate = operationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getOperationUnit() {
        return operationUnit;
    }

    public void setOperationUnit(String operationUnit) {
        this.operationUnit = operationUnit;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "id='" + id + '\'' +
                ", level=" + level +
                ", operationUnit='" + operationUnit + '\'' +
                ", method='" + method + '\'' +
                ", args='" + args + '\'' +
                ", uid='" + uid + '\'' +
                ", describe='" + describe + '\'' +
                ", operationType='" + operationType + '\'' +
                ", runTime=" + runTime +
                ", returnValue='" + returnValue + '\'' +
                ", operationDate=" + operationDate +
                '}';
    }
}
