package com.lxchannel.api.dto.order;

import com.lxchannel.api.dto.SignBaseReq;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 订单查询请求对象
 * Created by Niki on 2019/5/14 14:41
 */
@Data
@ToString(callSuper = true)
public class QueryOrderReq extends SignBaseReq {
    /**
     * 第三方订单号列表
     */
    private List<String> thirdOrderIdList;

    /**
     * 分期乐订单号
     */
    private List<String> orderIdList;
}
