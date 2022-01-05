package com.indonesia.openapi.help;

public class ResponeUtil {

    public static AppResponeUtil Respone(String status, Object data, String msg) {
        AppResponeUtil appResponeUtil = new AppResponeUtil();
        appResponeUtil.setStatus(status);
        appResponeUtil.setData(data);
        appResponeUtil.setMessage(msg);
        return appResponeUtil;
    }
    
}
