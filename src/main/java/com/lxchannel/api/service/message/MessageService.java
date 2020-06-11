package com.lxchannel.api.service.message;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.util.MessageSignUtil;

/**
 * 商户接受消息回调服务
 * Created by Niki on 2019/5/21 16:27
 */
public class MessageService {

    /**
     * 接受分期乐消息回调
     * @param receiveMsg
     * @return
     */
    public static JSONObject receiveMsg(JSONObject receiveMsg) {
        // 接受的消息进行验签，判断接收到的消息是否合法
        boolean valided = MessageSignUtil.validateMessage(receiveMsg);
        if (!valided) {
            // 校验不合法消息，可丢弃，可发送接受异常，分期乐会重新发送
            returnMsg(false);
        }

        int type = receiveMsg.getInteger("type");
        // // TODO: 2019/5/21 根据不同的消息类型进行不同的业务处理

        // 消息接收成功后，返回确认信息，避免分期乐重试
        return returnMsg(true);
    }

    /**
     * 消息接收成功，返回json串{"result":0},其他返回都认为参数接收失败。分期乐进行相应重试
     * @param succ
     * @return
     */
    private static JSONObject returnMsg(boolean succ) {
        JSONObject returnMsg = new JSONObject();
        returnMsg.put("result", 1);
        if (succ) {
            returnMsg.put("result", 0);
        }
        return returnMsg;
    }

}
