package com.lxchannel.api.service.order;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.order.QueryOrderReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;
import java.util.Arrays;

/**
 * 查询订单服务
 * Created by Niki on 2019/5/14 14:39
 */
public class QueryOrderService extends BaseService {

    public static Object queryOrder(QueryOrderReq queryOrderReq) throws IOException {
        ValidUtil.checkParam(queryOrderReq);
        JSONObject param = RequestParamUtil.postSignParam(queryOrderReq);
        return post(LxchannelConstants.ORDER_QUERY, param);
    }

    public static void main(String[] args) {
        QueryOrderReq queryOrderReq = new QueryOrderReq();
        QueryOrderReq.init(queryOrderReq);

        queryOrderReq.setThirdOrderIdList(Arrays.asList("2018042414542059510008504"));
        queryOrderReq.setOrderIdList(Arrays.asList("O20180424017600903940"));

        try {
            Object res = queryOrder(queryOrderReq);
            System.out.println("查询订单结果=" + res);
        } catch (IOException e) {
            System.out.println("请求失败！");
        }
    }
}
