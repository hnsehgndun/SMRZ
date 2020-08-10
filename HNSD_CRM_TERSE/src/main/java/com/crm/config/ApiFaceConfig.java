package com.crm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiFaceConfig {
//    @Value("#{configProperties['APP_ID']}")
    private static String APP_ID;
//    @Value("#{configProperties['API_KEY']}")
    private static String API_KEY;
//    @Value("#{configProperties['SECRET_KEY']}")
    private static String SECRET_KEY;

    public static String getAPP_ID() {
        return APP_ID;
    }

    @Value("#{configProperties['APP_ID']}")
    public void setAPP_ID(String APP_ID) {
        this.APP_ID = APP_ID;
    }

    public static String getAPI_KEY() {
        return API_KEY;
    }

    @Value("#{configProperties['API_KEY']}")
    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public static String getSECRET_KEY() {
        return SECRET_KEY;
    }

    @Value("#{configProperties['SECRET_KEY']}")
    public void setSECRET_KEY(String SECRET_KEY) {
        this.SECRET_KEY = SECRET_KEY;
    }
}
