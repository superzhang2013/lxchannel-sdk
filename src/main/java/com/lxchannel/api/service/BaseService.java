package com.lxchannel.api.service;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.util.HttpClientUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * 发送请求的基类
 * Created by Niki on 2019/5/14 10:26
 */
public class BaseService {

    /**
     * 发送GET请求
     *
     * @param url
     */
    public static JSONObject get(String url) throws IOException {
        HttpClient client = HttpClientUtil.client();
        try {
            HttpRequestBase request = HttpClientUtil.get(url);
            HttpResponse response = client.execute(request);
            return HttpClientUtil.res2Json(response);
        } finally {
            ((CloseableHttpClient) client).close();
        }
    }

    /**
     * 发送post请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static JSONObject post(String url, JSONObject json) throws IOException {
        HttpClient client = HttpClientUtil.client();
        try {

            HttpPost httpPost = HttpClientUtil.post(url, json.toJSONString());
            HttpResponse response = client.execute(httpPost);
            return HttpClientUtil.res2Json(response);
        } finally {
            ((CloseableHttpClient) client).close();
        }
    }


}
