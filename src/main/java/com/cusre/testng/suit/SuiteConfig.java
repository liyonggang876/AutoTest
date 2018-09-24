package com.cusre.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("b");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("a");
    }

    @BeforeTest
    public void est(){
        System.out.println("beofter test");
    }

    @AfterTest
    public void test(){
        System.out.println("after test");
    }
}
