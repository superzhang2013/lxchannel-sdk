package com.lxchannel.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 请求入参工具方法
 * Created by Niki on 2019/5/14 10:22
 */
public class RequestParamUtil {
    static SerializeConfig serializeConfig = new SerializeConfig();

    static {
        serializeConfig.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
    }

    /**
     * 签名post请求对象
     *
     * @param javaObject
     * @return
     */
    public static JSONObject postSignParam(Object javaObject) {
        JSONObject obj = snake(javaObject);
        // 参数签名
        SignUtil.sign(obj);
        // 参数必须存放于data
        return fqlProtocol(obj);
    }

    /**
     * 无需签名 post请求参数
     *
     * @param javaObject
     * @return
     */
    public static JSONObject postParam(Object javaObject) {
        JSONObject obj = snake(javaObject);
        // 参数必须存放于data
        return fqlProtocol(obj);
    }

    /**
     * 需要签名的get参数
     * @param url 接口请求rul
     * @param javaObject
     * @return
     */
    public static String getSignParam(String url, Object javaObject) {
        JSONObject obj = snake(javaObject);
        // 参数签名
        SignUtil.sign(obj);
        String params = mapToString(obj.getInnerMap());
        return toUrl(url,params);
    }

    /**
     * 无需签名的get参数
     * @param url 接口请求rul
     * @param javaObject
     * @return
     */
    public static String getParam(String url, Object javaObject) {
        JSONObject obj = snake(javaObject);
        String params = mapToString(obj.getInnerMap());
        return toUrl(url, params);
    }

    /**
     * 参数转下划线
     *
     * @param javaObject
     * @return
     */
    private static JSONObject snake(Object javaObject) {
        String snakeCase = JSON.toJSONString(javaObject, serializeConfig);
        // 参数转下划线
        JSONObject obj = JSON.parseObject(snakeCase);
        return obj;
    }


    private static JSONObject fqlProtocol(JSONObject param) {
        // 参数必须存放于data
        JSONObject res = new JSONObject();
        res.put("data", param);
        return res;
    }

    protected static String mapToString(Map<String, Object> params) {
        if (params == null || params.size() < 1) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            if (StringUtils.isEmpty(value)) {
                continue;
            }
            stringBuilder.append(key).append("=").append(value);
            stringBuilder.append("&");
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
    }

    private static String toUrl(String url, String param) {
        return url + "?" + param;
    }
}
