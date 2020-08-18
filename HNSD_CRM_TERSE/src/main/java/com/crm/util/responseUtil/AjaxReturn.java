package com.crm.util.responseUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WKX
 */
public class AjaxReturn extends HashMap<String,Object> {
    @Override
    public AjaxReturn put(String key, Object value){
        super.put(key, value);
        return this;
    }

    public AjaxReturn() {
        put("code",200);
        put("msg","success");
    }

    public static AjaxReturn error(int code, String msg) {
        AjaxReturn ajaxReturn = new AjaxReturn();
        ajaxReturn.put("code", code);
        ajaxReturn.put("msg", msg);
        return ajaxReturn;
    }

    public static AjaxReturn error() {
        return error(500, "未知错误");
    }

    public static AjaxReturn error(String msg) {
        return error(500, msg);
    }

    public static AjaxReturn success(){
        return new AjaxReturn();
    }

    public static AjaxReturn success(String msg){
        AjaxReturn ajaxReturn = new AjaxReturn();
        ajaxReturn.put("msg",msg);
        return ajaxReturn;
    }

    public static AjaxReturn success(Map<String,Object> map){
        AjaxReturn ajaxReturn = new AjaxReturn();
        ajaxReturn.putAll(map);
        return ajaxReturn;
    }

}
