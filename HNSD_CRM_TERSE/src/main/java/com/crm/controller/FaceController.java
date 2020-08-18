package com.crm.controller;

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.face.AipFace;
import com.crm.beans.Image;
import com.crm.beans.User;
import com.crm.config.MakeApiFace;
import com.crm.util.faceUtil.FaceUntilAPI;
import com.crm.util.responseUtil.JSONResponse;
import com.crm.util.responseUtil.ResSuccess;
import com.crm.util.responseUtil.ResponseUtils;
import com.crm.util.responseUtil.SystemErrors;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 人脸识别
 */

@CrossOrigin
@RestController
@RequestMapping("face")
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
            ResponseUtils.error(SystemErrors.SYS_308);
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
     * 人脸采集
     * @param
     * @return
     * 活体检测-人脸注册
     */
    @ApiOperation(value = "人脸对比接口")
    @RequestMapping("/match")
    public JSONResponse match(@RequestBody Image imageU, @RequestBody Image imagec, HttpServletRequest request){
        // 初始化一个AipFace
        org.json.JSONObject res = null;
       AipFace client = MakeApiFace.getAipFace();
        if(imageU==null&&imagec == null){
            return ResponseUtils.error(SystemErrors.SYS_420);
        }
        //调用工具类进行活体检测
        boolean faceverfy = FaceUntilAPI.faceverify(client,imageU,imagec);
        if (faceverfy){//活体
            //进行人脸对比
            //获取用户ID
            User user = (User)request.getSession().getAttribute("loginUser");
           // user.get
            //把图片和数据库重的实名认证身份证进行对比


            res = FaceUntilAPI.addUser(client,user,imageU);
            System.out.println(res);
        }
        return  ResponseUtils.success(ResSuccess.SYS_200, JSONObject.parseObject(res.toString()));

     /*   // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(imageU.getImage(), imageU.getImageType());

        *//*MatchRequest req2 = new MatchRequest(image2, "BASE64");*//*
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
       *//* requests.add(req2);*//*

        org.json.JSONObject res = client.match(requests);*/

    }

    /**
     * 人脸登陆
     * @param
     * @return
     * 活体检测-人脸搜索-人脸对比-
     */
    @ApiOperation(value = "人脸登陆")
    @RequestMapping("/facelogin")
    public JSONResponse facelogin(@RequestBody Image imageU, @RequestBody Image imagec, HttpServletRequest request){
        // 初始化一个AipFace
        org.json.JSONObject res = null;
        AipFace client = MakeApiFace.getAipFace();
        if(imageU==null&&imagec == null){
            return ResponseUtils.error(SystemErrors.SYS_420);
        }
        //调用工具类进行活体检测
        boolean faceverfy = FaceUntilAPI.faceverify(client,imageU,imagec);
        if (faceverfy){//活体
            //进行人脸对比
            //获取用户ID
            User user = (User)request.getSession().getAttribute("loginUser");

            res = FaceUntilAPI.addUser(client,user,imageU);
            System.out.println(res);
        }
        return  ResponseUtils.success(ResSuccess.SYS_200, JSONObject.parseObject(res.toString()));

     /*   // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(imageU.getImage(), imageU.getImageType());

        *//*MatchRequest req2 = new MatchRequest(image2, "BASE64");*//*
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
       *//* requests.add(req2);*//*

        org.json.JSONObject res = client.match(requests);*/

    }




}
