package com.crm.beans;


import java.io.Serializable;
import java.util.Date;

//操作记录日志
public class UserOperationRecord implements Serializable {
    private static final long serialVersionUID = 2682546718190823652L;
    private Integer id;
    private String username;
    private String operation;
    private String ipaddress;
    private Date operationDate;

    public UserOperationRecord() {
    }

    public UserOperationRecord(String username, String operation, String ipaddress, Date operationDate) {
        this.username = username;
        this.operation = operation;
        this.ipaddress = ipaddress;
        this.operationDate = operationDate;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    @Override
    public String toString() {
        return "UserOperationRecord{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", operation='" + operation + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", operationDate=" + operationDate +
                '}';
    }
}
