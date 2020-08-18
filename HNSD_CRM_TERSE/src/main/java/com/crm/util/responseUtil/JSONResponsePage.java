package com.crm.util.responseUtil;

//返回带有总条数的json对象
public class JSONResponsePage extends JSONResponse{

    private Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
