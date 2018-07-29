package com.htc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;

import Decoder.BASE64Encoder;

public class AIInterface {
	public static final String APP_ID = "11587048";
    public static final String API_KEY = "I2YPBhjtjDiRXMkcxaqZtH8w";
    public static final String SECRET_KEY = "rrYc0b2mpZ7PceDNqfMdg3XF0YyqWqGL";
    
    static AipFace client = null;
    AIInterface(){
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
    }
    /**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     * @param imgFile
     * @return
     */
    public String GetImageStr(String imgFile)  {  
        //String imgFile = "d://test.jpg";//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }
    
    /**
     * 添加用户照片
     * @param client
     * @param imagepath
     * @param groupId
     * @param userId
     */
    public void addUserPhoto(String imagepath, 
    		String groupId,String userId) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        
        String image = GetImageStr(imagepath);
        String imageType = "BASE64";
        
        // 人脸注册
        JSONObject res = client.addUser(image, imageType, groupId, userId, options);
        System.out.println(res.toString(2));

    }
    
    /**
     * 获取用户图片对的分数
     * @param groupid
     * @param userid
     * @param imagePath
     * @return
     */
    public double getScore(String groupid, String userid, String imagePath){
    		List<String> faceList = getFaceList(groupid, userid);
        return checkUser(imagePath, faceList);
    }
    
    /**
     * 查询图片对比度，返回相似值
     * @param client
     * @param image1
     * @param tokenList
     * @return
     */
    public double checkUser(String image1, List<String> tokenList) {
        String image1Str = GetImageStr(image1);
        //String image2Str = GetImageStr(image2);
        double sum = 0.0;
        int i=0;
        for(; i<tokenList.size(); i++){
        		// image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
            MatchRequest req1 = new MatchRequest(image1Str, "BASE64");
            MatchRequest req2 = new MatchRequest(tokenList.get(i), "FACE_TOKEN");
            ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
            requests.add(req1);
            requests.add(req2);

            JSONObject res = client.match(requests);
            //System.out.println(res.toString(2));
            String scoreStr = (((JSONObject)res.get("result")).get("score")).toString();
            double score = Double.parseDouble(scoreStr);
            sum += score;
        }
        return sum/i;
    }
    
    /**
     * 用户信息查询
     * @param client
     * @param groupId
     * @param userId
     */
    public void getUser(String groupId,String userId) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        
        // 用户信息查询
        JSONObject res = client.getUser(userId, groupId, options);
        System.out.println(res.toString(2));
    }
    
    /**
     * 获取用户图片列表信息
     * @param client
     * @param groupId
     * @param userId
     * @return
     */
    public static List<String> getFaceList(String groupId, String userId) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        ArrayList<String> ret = new ArrayList<String>();
        // 获取用户人脸列表
        JSONObject res = client.faceGetlist(userId, groupId, options);
        //System.out.println(res.toString(2));
        //System.out.println(res);
        JSONArray list = (JSONArray)((JSONObject) res.get("result")).get("face_list");
        for(int i = 0; i < list.length(); i++){
        		String temp = ((JSONObject)list.get(i)).get("face_token").toString() ;
        		//System.out.println(((JSONObject)list.get(i)).get("face_token"));
        		ret.add(temp);
        }
        return ret;
    }
}
