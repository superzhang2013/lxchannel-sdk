package com.lxchannel.api.dto.user;

import com.lxchannel.api.BusinessProperties;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 查询用户oauth信息请求对象
 * Created by Niki on 2019/5/15 16:55
 */
@Data
public class UserOauthReq {
    @NotNull(message = "商户id不能为空")
    private String clientId;
    @NotNull(message = "商户密钥不能为空")
    private String clientSecret;
    @NotNull(message = "code不能为空")
    private String code;

    public static UserOauthReq init() {
        UserOauthReq req = new UserOauthReq();
        req.setClientId(BusinessProperties.CLINET_ID);
        req.setClientSecret(BusinessProperties.CLIENT_SECRET);
        return req;
    }

}
