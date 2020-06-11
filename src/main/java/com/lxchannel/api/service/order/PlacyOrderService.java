package com.lxchannel.api.service.order;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.BusinessProperties;
import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.order.PlaycOrderReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;

/**
 * 用户下单服务
 * Created by Niki on 2019/5/14 11:31
 */
public class PlacyOrderService extends BaseService {
    public static Object placyOrderH5(PlaycOrderReq playcOrderReq) throws IOException {
        ValidUtil.checkParam(playcOrderReq);
        JSONObject param = RequestParamUtil.postSignParam(playcOrderReq);
        return post(LxchannelConstants.PLAYC_ORDER_H5, param);
    }

    public static Object placyOrderSDK(PlaycOrderReq playcOrderReq) throws IOException {
        ValidUtil.checkParam(playcOrderReq);
        JSONObject param = RequestParamUtil.postSignParam(playcOrderReq);
        return post(LxchannelConstants.PLAYC_ORDER_SDK, param);
    }

    public static void main(String[] args) {
        PlaycOrderReq playcOrderReq = new PlaycOrderReq();
        PlaycOrderReq.init(playcOrderReq);

        playcOrderReq.setFqNums(12);
        playcOrderReq.setAgent(BusinessProperties.AGENT);
        playcOrderReq.setThirdUid("1409016");
        playcOrderReq.setPhone("9634561");
        playcOrderReq.setAmount("120");
        playcOrderReq.setThirdOrderId("2019051318412463529");
        playcOrderReq.setCreateTime("2019-05-13 18:41:24");
        playcOrderReq.setSubject("测试商品");
        JSONObject attach = new JSONObject();
        playcOrderReq.setAttach("{\"goods_type\":1,\"is_pop\":0,\"goods_quantity\":1,\"register_time\":2018-01-03   17:56:48,\"name\":黄晓明,\"phone\":13866668888,\"address\":深圳市南山区粤海街道蔚蓝花园1栋B单元1608,\"account\":315895354}");
        playcOrderReq.setReceiveMsgUrl("http://www.baidu.com");
        playcOrderReq.setScene("1");
        playcOrderReq.setClientId(BusinessProperties.CLINET_ID);
        try {
            Object res = placyOrderH5(playcOrderReq);
            System.out.println("下单结果=" + res);
        } catch (IOException e) {
            System.out.println("请求失败");
        }
    }
}

