package com.crm.enums;


/**
 * AOP日志  操作类型
 */
public enum OperationType {
    //不知道的类型
    UNKNOWN("unknown"),
    //删除
    DELETE("delete"),
    //查询
    SELECT("select"),
    //更新
    UPDATE("update"),
    //插入
    INSERT("insert");

    private String value;

    OperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
