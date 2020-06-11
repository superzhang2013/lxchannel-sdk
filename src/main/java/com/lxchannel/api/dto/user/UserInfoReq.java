package com.lxchannel.api.dto.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户相关信息查询
 * Created by Niki on 2019/5/15 17:44
 */
@Data
public class UserInfoReq {
    @NotNull(message = "openId 不能为空")
    private String openId;

    @NotNull(message = "accessToken 不能为空")
    private String accessToken;

    private String agent;
}
