package com.http.demo.cookies;


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

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {

        String result;
//       从配置文件中 拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;


//        测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name
                    + ";  cookie value = " + value);
        }

    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = this.url + uri;
        String res = HttpClinet.doPost(testUrl,this.store);
        System.out.println("res=" + res);
        //声明client
        /*
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
        client.setCookieStore(this.store);
        //z执行post
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //返回结果处理
        JSONObject resultJson = new JSONObject(result);
        String success = (String)resultJson.get("huhansan");
        String status = (String)resultJson.get("status");

        Assert.assertEquals("success",success);
        Reporter.log("自己的日子111");
        Assert.assertEquals("1",status);
        */
    }
}
