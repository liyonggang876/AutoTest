package com.cusre.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDateProvider(String name,int age){
        System.out.println(name + age);
    }

    @DataProvider(name="data")
    public Object[][] prviderData(){
        Object[][] o =new Object[][]{
                {"zhang",10},
                {"lizi",5}
        };
        return o;

    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test111方法 name="+name+";age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test222方法 name="+name+";age="+age);
    }

    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result=null;

        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan",20},
                    {"lisi",25}
            };
        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu",50},
                    {"zhaoliu",60}
            };
        }

        return result;
    }

}
