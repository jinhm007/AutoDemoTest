package com.course.httpclient.cookies;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private  String  url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;


    @BeforeTest
    public void  beforeTest(){
        bundle=ResourceBundle.getBundle("application",Locale.CANADA);
        url=bundle.getString("test.url");

    }

    @Test
    public void  testGetCookies() throws IOException {
        String result;
        //从配置文件中 拼接测试的url
        String uri=bundle.getString("getCookies.uri");
        String testurl =this.url+uri;
        HttpGet get=new HttpGet(testurl);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result=EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(result);
        //获取Cookie值
        this.store=client.getCookieStore();
        List<Cookie> cookiesList= store.getCookies();
        for(Cookie cookie:cookiesList){
            String  name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("Cookie name="+name+" ;Cookie value="+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void  testPostWithCookie() throws IOException {
        String uri=bundle.getString("test.post.with.cookies");
        String testUrl=this.url+uri;
        DefaultHttpClient client=new DefaultHttpClient();
        HttpPost post=new HttpPost(testUrl);
        //添加参数
        JSONObject param=new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //设置请求头信息，设置Header信息
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity =new StringEntity(param.toString(),"UTF-8");
        post.setEntity(entity);
        //声明一个对象来存储响应的结果
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response=client.execute(post);
        //  获取响应结果
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        // 处理结果，判断返回结果是否符合预期
        //将返回的响应结果字符串转换成json对象
        JSONObject resultJson=JSONObject.parseObject(result);
        //具体判断返回的结果值
        //获取到结果值
        String success=(String)resultJson.get("huhansan");
        Assert.assertEquals("success",success);
        String i=(String) resultJson.get("status");
        Assert.assertEquals("1",i);

    }

}
