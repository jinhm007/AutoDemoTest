package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodDemo {

    @Test
    public  void  test01(){
        Assert.assertEquals(1,2);
    }


    @Test
    public  void  test02(){
        Assert.assertEquals(1,1);
    }


    @Test
    public  void  test03(){
        Assert.assertEquals("aa","aa");
    }


    @Test
    public  void logDemo(){
        Reporter.log("这是我自己写的log---jinhm");
        throw  new RuntimeException("这是我自己写的异常log");

    }
}
