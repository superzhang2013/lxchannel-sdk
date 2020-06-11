package com.lxchannel.api.service.order;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.order.RefundOrderReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;

/**
 * 部分退款服务
 * Created by Niki on 2019/5/14 15:10
 */
public class RefundOrderService extends BaseService {

    public static Object refundOrder(RefundOrderReq refundOrderReq) throws IOException {
        ValidUtil.checkParam(refundOrderReq);
        JSONObject param = RequestParamUtil.postSignParam(refundOrderReq);
        return post(LxchannelConstants.REFUND_ORDER, param);
    }
}
