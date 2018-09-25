package com.http.demo.json;

import org.json.JSONException;
import org.json.JSONObject;

public class Json {
    public static String createJsonString(String key, Object value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "bbbb");
        return jsonObject.toString();
    }


    public static void parseJsonObject(String json){
        //json={"name":"胡小威" , "age":20 , "male":true}
        //{"name":"胡小威", "age"=20, "male":true, "address":{"street":"岳麓山南", "city":"长沙","country":"中国"}}
        try{
            JSONObject jsonObject = new JSONObject(json);
            String name = jsonObject.getString("name");
            System.out.println("name" + name);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }









    public static void main(String[] args){
        String json="{\"name\":\"胡小威\",\"age\":20,\"male\":true}";
        json="{\"name\":\"胡1111小威\", \"age\":20, \"male\":true, \"address\":{\"street\":\"岳麓山南\",\"city\":\"长沙\",\"country\":\"中国\"}}";

        Json.parseJsonObject(json);
    }
}
