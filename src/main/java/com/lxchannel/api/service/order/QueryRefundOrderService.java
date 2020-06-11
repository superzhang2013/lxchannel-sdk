package com.lxchannel.api.service.order;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.order.QueryRefundOrderReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;

/**
 * Created by Niki on 2019/5/14 15:17
 */
public class QueryRefundOrderService extends BaseService {

    public static Object queryRefundOrder(QueryRefundOrderReq queryRefundOrderReq) throws IOException {
        ValidUtil.checkParam(queryRefundOrderReq);
        JSONObject param = RequestParamUtil.postSignParam(queryRefundOrderReq);
        return post(LxchannelConstants.QUERY_REFUND_ORDER, param);
    }

    public static void main(String[] args) {
        QueryRefundOrderReq queryRefundOrderReq = new QueryRefundOrderReq();
        QueryRefundOrderReq.init(queryRefundOrderReq);
        queryRefundOrderReq.setThirdRefundId("20180709570501725");
        try {
            Object res = queryRefundOrder(queryRefundOrderReq);
            System.out.println("查询部分退款=" + res);
        } catch (IOException e) {
            System.out.println("发送请求失败！");
        }
    }
}
