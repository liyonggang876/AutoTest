package com.http.demo.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class HttpClinet {
   // CookieStore store;
    public static String doGet(String testUrl,CookieStore store) throws IOException {
        String result;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(store);

        HttpResponse response = client.execute(get);

        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = " + statusCode);

        if(statusCode == 200){
            result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println("aaaa" + result);
            return result;
        }else{
            return "error";
        }
    }

    public static String doPost(String testUrl,CookieStore store) throws IOException {
        String res=null;
        DefaultHttpClient client = new DefaultHttpClient();


        //声明一个方法
        HttpPost post = new HttpPost(testUrl);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        //设置请求头信息
        post.setHeader("content-type","application/json");

        //将参数添加到方法
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象进行响应结果
        String result;
        //设置cook
        client.setCookieStore(store);
        //z执行post
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //返回结果处理
        JSONObject resultJson = new JSONObject(result);
        String success = (String)resultJson.get("huhansan");
        String status = (String)resultJson.get("status");

        //Assert.assertEquals("success",success);
        //Reporter.log("自己的日子111");
       // Assert.assertEquals("1",status);
        return success + status;
    }



}
