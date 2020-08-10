package com.crm.config;

import com.baidu.aip.face.AipFace;
import org.springframework.beans.factory.annotation.Autowired;

public class MakeApiFace extends AipFace {
    @Autowired
    private static ApiFaceConfig apiFaceConfig;

    private static MakeApiFace makeApiFace=new MakeApiFace(apiFaceConfig.getAPP_ID(),apiFaceConfig.getAPI_KEY(),apiFaceConfig.getSECRET_KEY());

    private MakeApiFace(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }

    public static AipFace getAipFace(){
        return makeApiFace;
    }
}
