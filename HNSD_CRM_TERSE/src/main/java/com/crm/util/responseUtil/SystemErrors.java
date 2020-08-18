package com.crm.util.responseUtil;

public enum SystemErrors implements IErrors {
    SYS_400("400", "无效的请求", ""),
    SYS_401("401", "无权限操作", "请联系在技术支持进行授权。"),
    SYS_402("402", "未找到服务地址", "确认REST服务是否注册，建议通过接口测试页面进行验证。"),
    SYS_403("403", "rest service invoke error", "确认REST服务是否注册，建议通过接口测试页面进行验证。"),
    SYS_420("420", "缺少参数%s", ""),
    SYS_424("424(", "%s参数重复。", ""),
    SYS_425("425", "timeout参数非法。", ""),
    SYS_426("426", "请求参数的值与类型不匹配。", ""),
    SYS_500("500", "Internal Server Error", ""),
    SYS_504("504", "请求超时", ""),
    SYS_307("307", "Incorrect format", ""),
    SYS_308("308", "存在非法字符", ""),
    SYS_309("309","用户名长度应该在6-15个字符",""),
    SYS_310("310","非法手机号",""),
    SYS_311("311","用户密码错误",""),
    SYS_312("312","不存在用户名",""),
    SYS_313("313","密码校验错误",""),
    SYS_314("314","认证过程失败,身份证号已经存在",""),
    SYS_315("315","身份证号格式错误","");

    private String code;
    private String message;
    private String solution;

    private SystemErrors(String code, String message, String solution) {
        this.code = code;
        this.message = message;
        this.solution = solution;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.code + ":" + this.message + "  解决方案：" + this.solution;
    }

    @Override
    public String getSolution() {
        return this.solution;
    }
}
