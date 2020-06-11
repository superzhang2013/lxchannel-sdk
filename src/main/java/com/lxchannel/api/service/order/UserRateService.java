package com.lxchannel.api.service.order;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.BusinessProperties;
import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.order.UserRateReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 用户下单服务
 * Created by Niki on 2019/5/14 10:14
 */
public class UserRateService extends BaseService {
    public static Object userRate(UserRateReq req) throws IOException {
        ValidUtil.checkParam(req);
        JSONObject param = RequestParamUtil.postSignParam(req);
        return post(LxchannelConstants.USER_RATE, param);
    }

    public static void main(String[] args) {
        UserRateReq userRateReq = new UserRateReq();
        UserRateReq.init(userRateReq);
        userRateReq.setAgent(BusinessProperties.AGENT);
        userRateReq.setLoadAmount(new BigDecimal("200"));

        try {
            Object resutl = UserRateService.userRate(userRateReq);
            System.out.println("用户费率试算结果" + resutl);
        } catch (IOException e) {
            System.out.println("请求出错！");
        }
    }
}
