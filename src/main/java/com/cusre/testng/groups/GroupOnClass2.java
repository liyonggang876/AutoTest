package com.cusre.testng.groups;


import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {
    public void stu1(){
        System.out.println("class2 stu1 run");
    }

    public void stu2(){
        System.out.println("class2 stu2 run");
    }
}
