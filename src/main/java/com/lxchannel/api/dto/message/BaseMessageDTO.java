package com.lxchannel.api.dto.message;

import lombok.Data;

/**
 * Created by Niki on 2019/5/21 16:20
 */
@Data
public class BaseMessageDTO {
    /**
     * 消息类型
     */
    private int type;

    /**
     * 消息发送时间
     */
    private long time;

    /**
     * 消息场景
     */
    private String method;

}
