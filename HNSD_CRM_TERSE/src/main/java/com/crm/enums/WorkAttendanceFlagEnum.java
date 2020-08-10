package com.crm.enums;

//打卡考勤的状态枚举
public enum WorkAttendanceFlagEnum {

    SIMPLE_ON_WORK(1,"正常上班时间"),
    SIMPLE_DOWN_WORK(2,"正常下班时间"),
    LATE_WORK(3,"迟到"),
    LEVEL_WORK(4,"早退"),
    QINGJIA_WORK(5,"请假");


    private Integer work_state;
    private String work_desc;

    public Integer getWork_state() {
        return work_state;
    }

    public void setWork_state(Integer work_state) {
        this.work_state = work_state;
    }

    public String getWork_desc() {
        return work_desc;
    }

    public void setWork_desc(String work_desc) {
        this.work_desc = work_desc;
    }
    WorkAttendanceFlagEnum(Integer work_state, String work_desc) {
        this.work_state = work_state;
        this.work_desc = work_desc;
    }
}
