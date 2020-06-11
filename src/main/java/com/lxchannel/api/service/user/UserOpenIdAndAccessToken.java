package com.lxchannel.api.service.user;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.user.UserOauthReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;

/**
 * 查询用户oauth信息服务
 * 1、用户openid
 * 2、用户access_token
 * 3、用户refresh_token
 * access_token的有效期为7天
 * refresh_token有效期为180天。当access_token过期后用来换取新的access_token
 * 商户应自行存储用户相关的oauth数据。并且在access_token过期后刷新
 * Created by Niki on 2019/5/15 16:50
 */
public class UserOpenIdAndAccessToken extends BaseService {

    public static Object userOauthInfo(UserOauthReq userOauthReq) throws IOException {
        ValidUtil.checkParam(userOauthReq);
        JSONObject param = RequestParamUtil.postParam(userOauthReq);
        return post(LxchannelConstants.ACCESS_TOKEN_URL, param);
    }

    public static void main(String[] args) {
        UserOauthReq userOauthReq = UserOauthReq.init();
        userOauthReq.setCode("31674813CA7A2BA24A625C61CA96CC9439825c13");
        try {
            Object res = userOauthInfo(userOauthReq);
            System.out.println("获取用户oauth信息=" + res);
        } catch (IOException e) {
            System.out.println("请求失败！");
        }
    }
}
