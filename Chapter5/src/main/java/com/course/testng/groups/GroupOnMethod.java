package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @Test(groups = "client")
    public  void  test01(){
        System.out.println("这是客户端组的测试1111");
    }

    @Test(groups = "client")
    public  void  test02(){
        System.out.println("这是客户端组的测试22222");
    }

    @Test(groups = "client")
    public  void  test03(){
        System.out.println("这是客户端组的测试3333");
    }

    @Test(groups = "server")
    public  void  test04(){
        System.out.println("这是服务端组的测试11111");
    }


    @Test(groups = "server")
    public  void  test05(){
        System.out.println("这是服务端组的测试22222");
    }


    @Test(groups = "server")
    public  void  test06(){
        System.out.println("这是服务端组的测试33333");
    }

    @BeforeGroups("client")
    public void beforeGroupOnClient(){
        System.out.println("这是客户端组运行之前运行的方法");
    }

    @AfterGroups("client")
    public  void  afterGroupOnClient(){
        System.out.println("这是客户端组运行之后运行的方法");
    }

    @BeforeGroups("server")
    public void beforeGroupOnServer(){
        System.out.println("这是服务端组运行之前运行的方法");
    }

    @AfterGroups("server")
    public  void  afterGroupOnServer(){
        System.out.println("这是服务端组运行之后运行的方法");
    }
}
