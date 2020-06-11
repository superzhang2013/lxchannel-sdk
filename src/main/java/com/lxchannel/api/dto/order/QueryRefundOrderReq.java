package com.lxchannel.api.dto.order;

import com.lxchannel.api.dto.SignBaseReq;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 查询部分退款请求 对象
 * Created by Niki on 2019/5/14 15:17
 */
@Data
@ToString(callSuper = true)
public class QueryRefundOrderReq extends SignBaseReq {
    @NotNull(message = "第三方退款流水号不允许为null")
    private String thirdRefundId;
}
