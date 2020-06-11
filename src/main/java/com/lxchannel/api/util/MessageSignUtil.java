package com.lxchannel.api.util;

import com.alibaba.fastjson.JSONObject;

/**
 * 消息回调验证工具
 * Created by Niki on 2019/5/21 16:31
 */
public class MessageSignUtil {

    /**
     * 校验消息是否合法
     * @param receiveMsg
     * @return
     */
    public static boolean validateMessage(JSONObject receiveMsg) {
        if (!receiveMsg.containsKey("sign")) {
            return false;
        }
        String sign = (String) receiveMsg.remove("sign");
        SignUtil.sign(receiveMsg);
        String checkSign = (String) receiveMsg.remove("sign");
        return checkSign.equals(sign);
    }
}
