package com.geekjava0study.demo.week2;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/10/27 21:37
 */
public class HttpUtils {

    public static void main(String[] args) {
        System.out.println(doGet("http://localhost:8801/"));
    }

    public static String doGet(String url)
    {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);

            CloseableHttpResponse Response = client.execute(httpGet);
            // HttpEntity
            // 是一个中间的桥梁，在httpClient里面，是连接我们的请求与响应的一个中间桥梁，所有的请求参数都是通过HttpEntity携带过去的
            // 所有的响应的数据，也全部都是封装在HttpEntity里面
            HttpEntity entity = Response.getEntity();
            // 通过EntityUtils 来将我们的数据转换成字符串
            String str = EntityUtils.toString(entity, "UTF-8");
            // 关闭
            Response.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "req_error";
        }
    }
}
