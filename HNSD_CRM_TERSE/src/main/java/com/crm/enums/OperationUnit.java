package com.crm.enums;


import jdk.nashorn.internal.objects.annotations.Getter;

public enum OperationUnit {
    /**
     * 被操作的单元
     */
    USER("User"),
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
