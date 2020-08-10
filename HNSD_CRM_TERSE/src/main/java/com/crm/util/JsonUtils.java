package com.crm.util;

import com.alibaba.fastjson.JSONObject;

/**
 * JSON
 */
public class JsonUtils {

    /**
     * 判断是否是JSON
     * @param string
     * @return
     */
    public static boolean isjson(String string){
        try {
            JSONObject jsonStr= JSONObject.parseObject(string);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }
}
