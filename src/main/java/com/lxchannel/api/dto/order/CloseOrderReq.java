package com.lxchannel.api.dto.order;

import com.lxchannel.api.dto.SignBaseReq;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 关闭订单请求对象
 * Created by Niki on 2019/5/14 15:28
 */
@Data
@ToString(callSuper = true)
public class CloseOrderReq extends SignBaseReq {
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

    /**
     * 订单状态值
     * 15 表示关单，全额退款
     */
    @NotNull(message = "订单状态不允许为空")
    private Integer merchSaleState = 15;

    /**
     * 第三方退款流水号
     */
    private String thirdRefundId;


}
