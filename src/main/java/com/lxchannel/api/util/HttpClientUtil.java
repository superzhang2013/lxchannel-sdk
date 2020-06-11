package com.lxchannel.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: dogyu
 * @Date: 2018/10/30
 * @Description:
 */
public class HttpClientUtil {
    private HttpClientUtil() {

    }

    /**
     * 发送GET请求
     *
     * @param url
     */
    public static HttpRequestBase get(String url) {
        HttpRequestBase request = new HttpGet(url);
        return request;

    }

    public static HttpPost post(String url, String json) {
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        return httpPost;
    }

    /**
     * 发送post请求
     *
     * @return
     * @throws IOException
     */
    public static HttpClient client() throws IOException {
        //请求设置
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .setRedirectsEnabled(false)
                .build();

        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setDefaultRequestConfig(config);
        HttpClient client = builder.build();

        return client;
    }

    public static String res2String(HttpResponse resp) throws IOException {
        return res2String(resp, "utf-8");
    }

    /**
     * 获取请求结果的值
     *
     * @param resp     请求结果对象
     * @param encoding 编码方式
     * @return 请求结果字符串
     * @throws IOException
     */
    public static String res2String(HttpResponse resp, String encoding) throws IOException {
        String body = "";
        try {
            if (resp.getEntity() != null) {
                // 按指定编码转换结果实体为String类型
                body = EntityUtils.toString(resp.getEntity(), encoding);
            } else {//有可能是head请求
                body = resp.getStatusLine().toString();
            }
            EntityUtils.consume(resp.getEntity());
        } finally {
            if (resp != null) {
                if (CloseableHttpResponse.class.isAssignableFrom(resp.getClass())) {
                    ((CloseableHttpResponse) resp).close();
                }
            }
        }
        return body;
    }

    public static JSONObject res2Json(HttpResponse response) throws IOException {
        String res = res2String(response);
        return JSON.parseObject(res);
    }
}
