package com.course.testng;

import org.testng.annotations.*;

public class BaseAnnotation {

    @Test
    public void testCase01() {
        System.out.println("这是testCase1测试用例");
    }

    @Test
    public void testCase02() {
        System.out.println("这是testCase2测试用例");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("这是方法之前执行");

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("这是方法之后执行");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("@BeforeClass这是方法之前执行");
    }

    @AfterClass
    public  void afterClass(){
        System.out.println("@AfterClass这是方法之前执行");
    }

    @BeforeSuite
    public  void  beforeSuit(){
        System.out.println("@BeforeSuit这是方法之前执行");
    }

    @AfterSuite
    public  void  afterSuit(){
        System.out.println("@BeforeSuit这是方法之前执行");
    }
}
