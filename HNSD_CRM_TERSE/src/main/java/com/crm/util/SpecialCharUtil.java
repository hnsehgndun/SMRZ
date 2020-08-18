package com.crm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//匹配特殊符号工具类
public class SpecialCharUtil {

    /**
     * 匹配特殊字符
     * @param username
     * @return
     */
    public static boolean patternChar(String username) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(username);
        return m.matches();
    }

    /**
     * 匹配手机号
     * @param uphone
     * @return
     */
    public static boolean patternPhone(String uphone) {
        String s2 = "^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$";// 验证手机号
        Pattern p = Pattern.compile(s2);
        Matcher m = p.matcher(uphone);
        return m.matches();
    }
}
