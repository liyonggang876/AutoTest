package com.cusre.testng;

import org.testng.annotations.*;

public class TestNg {

    @Test
    public void test1(){
        System.out.println("这是测试用例1");
    }

    @BeforeMethod
    public void test2(){
        System.out.println("fangfaizhiqian");
    }
    @AfterMethod
    public void test3(){
        System.out.println("fatermaisn");
    }

    @BeforeClass
    public void test4(){
        System.out.println("leizhiq");
    }

    @AfterClass
    public void test5(){
        System.out.println("leizhihou");
    }

    @BeforeSuite
    public void beforesuite(){
        System.out.println("cestiaoj");
    }

    @AfterSuite
    public void after(){
        System.out.println("ceshisiut");
    }
}
