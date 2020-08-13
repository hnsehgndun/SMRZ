package com.crm.enums;


/**
 * AOP日志  被操作的单元
 */
public enum OperationUnit {
    //user对象
    USER("User"),
    //考勤对象
    WORKATTENDANCE("WorkAttendance");

    private String value;

    OperationUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
