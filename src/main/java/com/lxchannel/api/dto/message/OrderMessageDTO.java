package com.lxchannel.api.dto.message;

import lombok.Data;

/**
 * 订单消息
 * Created by Niki on 2019/5/21 16:14
 */
@Data
public class OrderMessageDTO {
    /**
     * 用户分期乐对应的oepnid
     */
    private String thirdUid;

    /**
     * 用户分期乐openid，用来取消thirdUid
     */
    private String openId;

    /**
     * 商户订单channel
     */
    private String channel;

    /**
     * 用户借款订单是否在本商户为首单 1：是，0：否
     */
    private int isFirstOrder;

    /**
     * 用户授信是否在本商户开户 1：是，0：否
     */
    private int isOurAgent;

    /**
     * 用户借钱订单id
     */
    private String orderId;

    /**
     * 订单金额
     */
    private double amount;

    /**
     * 订单分期月数
     */
    private int month;

}
