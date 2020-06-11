package com.lxchannel.api.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.BusinessProperties;
import com.lxchannel.api.LxchannelConstants;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Niki on 2019/5/14 10:38
 *
 * 接口参数加密调用实例
 * 加密规则：
 * 1. 对所有 API 请求参数（包括公共参数和业务参数，但除去 sign 参数和值为 array()类型的参数），根
 * 据参数名称的 ASCII 码表顺序升序排列。
 * 如：foo=1, bar=2, foo_bar=3, foobar=4 排序后的顺序是 bar=2, foo=1, foo_bar=3, foobar=4。
 * 2. 将排好序的参数名、参数值用&拼装在一起，采用 utf-8 编码。
 * 接上，bar=2&foo=1&foo_bar=3&foobar=4。
 * 3. 使用签名算法对编码后的字节流进行摘要。
 * 如果使用 MD5 算法，则需要在拼装的字符串尾部加上 app 的 partner_key 后，再进行摘要，
 * 如：md5(bar=2&foo=1&foo_bar=3&foobar=4&partner_key=secret)，将字节流转换为 32 个 16 进制
 * 字符。
 * 请参照此文档结合自身业务逻辑，完成参数加密算法。
 */
public class SignUtil {
    private static String parentKey = "partner_key";

    private SignUtil() {
    }


    /**
     * 获取sign值
     * @param params
     * @return
     */
    public static String getSign(Map<String, Object> params){
        Map<String, Object> sortMap = sortParams(params);
        String paramString = getParamString(sortMap);
        return encode(paramString);
    }

    /**
     * 对参数进行签名
     * @param param
     */
    public static void sign(JSONObject param) {
        Map<String, Object> paramMap = param.getInnerMap();
        paramMap = sortParams(paramMap);
        String paramUrl = getParamString(paramMap);
        String sign = encode(paramUrl);
        param.put("sign", sign);
    }

    /**
     * 参数按照ASCII排序
     * @param params
     * @return
     */
    protected static Map<String, Object> sortParams(Map<String, Object> params){
        return new TreeMap<String, Object>(params);
    }


    /**
     * 所有参数key=value&连接
     * partner_key不参与排序，放在参数最后面
     * @param params
     * @return
     */
    private static String getParamString (Map<String, Object> params){
        if(!params.containsKey(parentKey)){
            params.put(parentKey, BusinessProperties.PARTNER_KEY);
        }
        String parentValue = params.get(parentKey).toString();
        //排序去掉parentKey
        params.remove(parentKey);
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof List || entry.getValue() instanceof JSONArray) {
                // 数组类型参数不参与签名
                continue;
            }
            String value = entry.getValue().toString();
            if (StringUtils.isEmpty(value)) {
                // 空字符串不参与签名
                continue;
            }
            stringBuilder.append(key).append("=").append(value);
            stringBuilder.append("&");
        }
        stringBuilder.append(parentKey).append("=").append(parentValue);
        return stringBuilder.toString();
    }

    /**
     * 参数编码
     * @param params
     * @return
     */
    private static String encode(String params){
        return DigestUtils.md5Hex(params);
    }

}
