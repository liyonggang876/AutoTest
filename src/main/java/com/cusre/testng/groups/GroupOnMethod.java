package com.cusre.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组1111");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组222");
    }


    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端组222");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组444");
    }

    @BeforeGroups("server")
    public void beforeGroupOnserver(){
        System.out.println("这是服务端组运行之前");
    }
    @AfterGroups("server")
    public void afgerGroupOnserver(){
        System.out.println("这是服务端组运行之前");
    }

    @BeforeGroups("client")
    public void beforeGroupOnserver1(){
        System.out.println("这是客户端运行之前");
    }
    @AfterGroups("client")
    public void afgerGroupOnserver1(){
        System.out.println("这是客户端组运行之前");
    }
}
