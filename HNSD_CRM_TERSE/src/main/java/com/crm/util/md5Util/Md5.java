package com.crm.util.md5Util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Md5 {

    private static String MD5_KEY = "test";

    private static Logger logger = LoggerFactory.getLogger(com.crm.util.md5Util.Md5.class);

    //加密  返回加密后的字符串
    public static String md5(String text) {
        //加密后的字符串
        String encodeStr = DigestUtils.md5Hex(text + MD5_KEY);
        logger.debug("MD5加密后的字符串为:{}" + encodeStr);
        return encodeStr;
    }

    /**
     * 验证
     *
     * @param text
     * @param md5  加密后的字符串
     * @return
     * @throws Exception
     */
    public static boolean verify(String text, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text);
        if (md5Text.equalsIgnoreCase(md5)) {
            logger.debug("MD5验证通过");
            return true;
        }
        return false;
    }
}
