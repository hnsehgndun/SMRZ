package com.crm.util.responseUtil;



import java.io.Serializable;

public class JSONResponse<T> implements Serializable {
    private static final long serialVersionUID = 6778195529803010132L;

    private String code;

    private String message;

    private T data;

    private boolean success;

    private Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public JSONResponse() {
    }

    public JSONResponse(String code, String message, T data, boolean success) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public JSONResponse(String code, String message, T data, boolean success, Long total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
        this.total = total;
    }
}
