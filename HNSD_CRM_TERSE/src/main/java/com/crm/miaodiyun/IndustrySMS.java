package com.crm.miaodiyun;

import java.net.URLEncoder;


/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS {
	private static String accountSid = Config.ACCOUNT_SID;
	private static String to = "15737161830";
	private static String smsContent = "您的验证码为15265，请于30分钟内正确输入，如非本人操作，请忽略此短信。";


	public static void execute(String phoneNum,String randomNum) throws Exception{
		StringBuilder sb = new StringBuilder();
		sb.append("accountSid").append("=").append(Config.ACCOUNT_SID);
		sb.append("&to").append("=").append(phoneNum);
		sb.append("&param").append("=").append(URLEncoder.encode("","UTF-8"));
		sb.append("&smsContent").append("=").append( URLEncoder.encode("【秒嘀科技】您的验证码为"+randomNum+"，该验证码5分钟内有效。请勿泄漏于他人。","UTF-8"));
		String body = sb.toString() + HttpUtil.createCommonParam(Config.ACCOUNT_SID, Config.AUTH_TOKEN);
		String result = HttpUtil.post(Config.BASE_URL, body);
		System.out.println(result);

	}
}
