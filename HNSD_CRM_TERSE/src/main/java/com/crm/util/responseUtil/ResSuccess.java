package com.crm.util.responseUtil;

/**
 * 返回成功状态
 */
public enum ResSuccess {
	SYS_200("200", "操作成功");

	private String code;
	private String message;

	ResSuccess(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
