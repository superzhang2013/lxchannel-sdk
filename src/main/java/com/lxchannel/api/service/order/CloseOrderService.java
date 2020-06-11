package com.lxchannel.api.service.order;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.order.CloseOrderReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;

/**
 * 关闭订单，全额服务
 * Created by Niki on 2019/5/14 15:30
 */
public class CloseOrderService extends BaseService {

    public Object closeOrder(CloseOrderReq closeOrderReq) throws IOException {
        ValidUtil.checkParam(closeOrderReq);
        JSONObject param = RequestParamUtil.postSignParam(closeOrderReq);
        return post(LxchannelConstants.CLOSE_ORDER, param);
    }
}
