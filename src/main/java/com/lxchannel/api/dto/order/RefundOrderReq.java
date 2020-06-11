package com.lxchannel.api.dto.order;

import com.lxchannel.api.dto.SignBaseReq;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Created by Niki on 2019/5/14 15:08
 */
@Data
@ToString(callSuper = true)
public class RefundOrderReq extends SignBaseReq {
    /**
     * 第三方订单号
     */
    @NotNull(message = "第三方订单号不允许为空")
    private String thirdOrderId;

    /**
     * 分期乐订单号
     */
    @NotNull(message = "分期乐订单号不允许为空")
    private String orderId;

    private String amount;

    @NotNull(message = "第三方退款流水号不允许为null")
    private String thirdRefundId;
}
