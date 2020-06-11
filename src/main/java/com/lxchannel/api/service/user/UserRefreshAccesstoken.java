package com.lxchannel.api.service.user;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.BusinessProperties;
import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.user.RefreshTokenReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;

/**
 * 刷新用户的accesstoken
 * Created by Niki on 2019/5/15 16:51
 */
public class UserRefreshAccesstoken extends BaseService {
    public static Object refreshAccessToken(RefreshTokenReq req) throws IOException {
        ValidUtil.checkParam(req);
        JSONObject param = RequestParamUtil.postParam(req);
        return post(LxchannelConstants.REFRESH_TOKEN_URL, param);
    }

    public static void main(String[] args) {
        RefreshTokenReq req = new RefreshTokenReq();
        req.setClientId(BusinessProperties.CLINET_ID);
        req.setRefreshToken("39bff8cc4682c803c81e16c880948a19855722e6");

        try {
            Object res = refreshAccessToken(req);
            System.out.println("刷新用户accesstoken结果=" + res);
        } catch (IOException e) {
            System.out.println("请求失败");
        }
    }
}
