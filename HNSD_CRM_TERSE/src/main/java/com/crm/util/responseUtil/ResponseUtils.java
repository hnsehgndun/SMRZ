package com.crm.util.responseUtil;


/**
 * 响应工具类，项目组根据项目实际情况自己制定和前端的交互格式
 * 此处仅是一种样例。
 */
public class ResponseUtils {

    public ResponseUtils() {
    }

    public static JSONResponse success() {
        return success(new String());
    }

    public static <T> JSONResponse<T> success(T data) {
        return success(ResSuccess.SYS_200, data);
    }

    public static JSONResponse success(ResSuccess resSuccess) {
        return success((ResSuccess) resSuccess, (Object) null);
    }

    public static <T> JSONResponse<T> success(ResSuccess resSuccess, T data) {
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setSuccess(true);
        jsonResponse.setData(data);
        jsonResponse.setCode(resSuccess.getCode());
        jsonResponse.setMessage(resSuccess.getMessage());
        return jsonResponse;
    }

    public static JSONResponse success(String message) {
        return success(ResSuccess.SYS_200.getCode(), message, (Object) null);
    }

    public static JSONResponse success(String code, String message) {
        return success(code, message, (Object) null);
    }

    public static <T> JSONResponse<T> success(String code, String message, T data) {
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setSuccess(true);
        jsonResponse.setData(data);
        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        return jsonResponse;
    }

    public static JSONResponse error(SystemErrors resError) {
        return error((SystemErrors) resError, (Object) null);
    }

    public static <T> JSONResponse<T> error(SystemErrors resError, T data) {
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setSuccess(false);
        jsonResponse.setData(data);
        jsonResponse.setCode(resError.getCode());
        jsonResponse.setMessage(resError.getMessage());
        return jsonResponse;
    }

    public static JSONResponse error(String message) {
        return error(SystemErrors.SYS_500.getCode(), message, (Object) null);
    }

    public static JSONResponse error(String code, String message) {
        return error(code, message, (Object) null);
    }

    public static <T> JSONResponse<T> error(String code, String message, T data) {
        JSONResponse jsonResponse = new JSONResponse();
        jsonResponse.setSuccess(false);
        jsonResponse.setData(data);
        jsonResponse.setCode(code);
        jsonResponse.setMessage(message);
        return jsonResponse;
    }
}
