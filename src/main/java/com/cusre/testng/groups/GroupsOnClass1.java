package com.cusre.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {

    public void stu1(){
        System.out.println("class1 stu1 run");
    }

    public void stu2(){
        System.out.println("class1 stu2 run");
    }
}
