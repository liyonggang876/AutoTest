package com.test.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMethodDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test3(){
        Reporter.log("aaa");
        Assert.assertEquals("a","b");

    }
    @Test
    public void test4(){
        Reporter.log("zheshiyic");
    }

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
}
