package com.lxchannel.api.dto.message;

import lombok.Data;

/**
 * 授信消息对象内容
 * Created by Niki on 2019/5/21 16:13
 */
@Data
public class CreditMessageDTO {
    /**
     * 用户分期乐对应的oepnid
     */
    private String thirdUid ;

    /**
     * 用户分期乐openid，用来取消thirdUid
     */
    private String openId;

    /**
     * 用户授信的agent
     */
    private String agent;

    /**
     * 授信单号
     */
    private String orderId;
}
