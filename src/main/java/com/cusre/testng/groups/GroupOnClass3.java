package com.cusre.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupOnClass3 {
    public void t1(){
        System.out.println("class3 t1 run");
    }

    public void t2(){
        System.out.println("class3 t2 run");
    }
}
