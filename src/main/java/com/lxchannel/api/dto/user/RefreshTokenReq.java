package com.lxchannel.api.dto.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by Niki on 2019/5/15 17:35
 */
@Data
public class RefreshTokenReq {
    @NotNull(message = "商户id不能为空")
    private String clientId;
    @NotNull(message = "refreshToken不能为空")
    private String refreshToken;
}
