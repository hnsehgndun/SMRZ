package com.crm.controller;

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.crm.config.MakeApiFace;
import com.crm.util.JsonUtils;
import com.crm.util.responseUtil.JSONResponse;
import com.crm.util.responseUtil.ResSuccess;
import com.crm.util.responseUtil.ResponseUtils;
import com.crm.util.responseUtil.SystemErrors;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 人脸识别
 */

@RestController
@RequestMapping("/face")
public class FaceController{
    /**
     * 人脸识别
     * @param
     * @return
     */
    @ApiOperation(value = "人脸检测接口")
    @PostMapping("/detect")
    public JSONResponse detect(@RequestBody HashMap<String,String> param){
        String image = param.get("image");
        if(StringUtils.isEmpty(image)){
            return ResponseUtils.error(SystemErrors.SYS_308);
        }
        // 初始化一个AipFace
        AipFace client =  MakeApiFace.getAipFace();

        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        String imageType = "BASE64";

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age");
//        options.put("max_face_num", "2");
//        options.put("face_type", "LIVE");
//        options.put("liveness_control", "LOW");
        // 人脸检测
        org.json.JSONObject res = client.detect(image, imageType, options);
        return ResponseUtils.success(ResSuccess.SYS_200, JSONObject.parseObject(res.toString()));
    }


    /**
     * 对比
     * @param
     * @return
     */
    @ApiOperation(value = "人脸对比接口")
    @PostMapping("/match")
    public JSONResponse match(@RequestBody HashMap<String,String> param){
        // 初始化一个AipFace
       AipFace client = MakeApiFace.getAipFace();
        String image1 = param.get("image1");
        String image2 = param.get("image2");
        if(StringUtils.isEmpty(image1) && StringUtils.isEmpty(image2)){
            return ResponseUtils.error(SystemErrors.SYS_308);
        }

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(image1, "BASE64");
        MatchRequest req2 = new MatchRequest(image2, "BASE64");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        org.json.JSONObject res = client.match(requests);
        return  ResponseUtils.success(ResSuccess.SYS_200, JSONObject.parseObject(res.toString()));
    }





}
