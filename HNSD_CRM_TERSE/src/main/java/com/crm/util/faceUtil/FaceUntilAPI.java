package com.crm.util.faceUtil;

import com.alibaba.fastjson.JSONArray;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.FaceVerifyRequest;
import com.baidu.aip.face.MatchRequest;
import com.crm.beans.Image;
import com.crm.beans.User;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FaceUntilAPI {

    /**
     * 人脸对比
     * @param client
     * @param imageU
     * @param imageC
     * @return
     */
    public static String facecomparison(AipFace client, Image imageU, Image imageC){

        MatchRequest req1 = new MatchRequest(imageU.getImage(), imageU.getImageType());
        MatchRequest req2 = new MatchRequest(imageC.getImage(), imageC.getImageType());
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);
        //调用百度接口人脸对比
        JSONObject res = client.match(requests);
        return res.toString(2);

    }

    /**
     * 活体检测
     * @param client
     * @param imageU
     * @param imageC
     * @return
     */

    public static  boolean faceverify(AipFace client, Image imageU, Image imageC){
        FaceVerifyRequest fvr = new FaceVerifyRequest(imageU.getImage(), imageU.getImageType());
        FaceVerifyRequest fvr2 = new FaceVerifyRequest(imageC.getImage(), imageC.getImageType());

        List<FaceVerifyRequest> list = new ArrayList<FaceVerifyRequest>();
        list.add(fvr);
        list.add(fvr2);
        JSONObject res = client.faceverify(list);//活体检测
        String rest = "["+res+"]";
        //百度返回值转list
        List <Map> list1 = JSONArray.parseObject(rest,List.class);
        if (list1!=null&&list1.size()>0){
            Map mresult = list1.get(0);
            if ("SUCCESS".equals(mresult.get("error_msg"))){

                System.out.println("活体检测接口调用成功-----------------------");
                //获取result中的值
                String sresult = "["+String.valueOf(mresult.get("result"))+"]";
                //result转list
                List <Map> list2 = JSONArray.parseObject(sresult,List.class);
                System.out.println(list2);
                HashMap<String, String> map = new  HashMap();
                if(list2!=null&&list2.size()>0){
                    if("1".equals(String.valueOf(list2.get(0).get("face_liveness")))){//判断是否为活体
                        //调用人脸注册借口 将人脸数据存入数据库中并存入数据库中
                        JSONObject user =
                                client.updateUser(imageU.getImage(),imageU.getImageType(),"groupID","userID",map);
                        // 入库

                        return true;

                    }
                }
            }
        }
        return false;
    }

    /**
     * 人脸注册
     * @param client
     * @param user
     * @param image
     * @return
     */
    public static  JSONObject addUser(AipFace client , User user , Image image){
        //User user = (User) session.getAttribute("loginUser");
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        JSONObject res  = client.addUser(image.getImage(),image.getImageType(),"SMRZ",
                 String.valueOf(user.getId()),options);
        System.out.println(res);
        return res;
    }

    /**
     * 人脸搜索
     * @param client
     * @param image
     * @return
     */
    public static  JSONObject search(AipFace client , Image image) {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("max_user_num", "1");


        String groupIdList = "SMRZ";

        // 人脸搜索
        JSONObject res = client.search(image.getImage(), image.getImageType(), groupIdList, options);
        return res;
    }

    public static String Facecomparison(AipFace client, Image imageU, Image imageC){

        MatchRequest req1 = new MatchRequest(imageU.getImage(), imageU.getImageType());
        MatchRequest req2 = new MatchRequest(imageC.getImage(), imageC.getImageType());
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);
        JSONObject res = client.match(requests);
        return res.toString(2);

    }
}
