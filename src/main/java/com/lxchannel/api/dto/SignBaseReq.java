package com.lxchannel.api.dto;

import com.lxchannel.api.BusinessProperties;
import com.lxchannel.api.LxchannelConstants;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 异业合作商户签名参数
 * Created by Niki on 2019/5/14 10:03
 */
@Data
public class SignBaseReq {
    /**
     * Pop 验证时间搓
     */
    @NotNull(message = "时间戳不允许为null")
    private String timestamp;

    /**
     * 商户partnerId
     */
    @NotNull(message = "partnerId不允许为null")
    private String partnerId;

    /**
     * 响应格式
     */
    @NotNull(message = "响应格式不允许为null")
    private String format;

    /**
     * API协议版本 当前可选值 1.4
     */
    @NotNull(message = "API协议版本不允许为null")
    private String v;

    /**
     * 默认的请求协议基本参数。可根据实际情况修改；
     * @return
     */
    public static  <T extends SignBaseReq>  void init(T signBaseReq) {
        signBaseReq.setFormat(LxchannelConstants.API_DEFAULT_FORMAT);
        signBaseReq.setV(LxchannelConstants.API_DEFAULT_VERSION);
        signBaseReq.setPartnerId(BusinessProperties.PARTNER_ID);
        signBaseReq.setTimestamp(Long.toString(System.currentTimeMillis()));
    }

}
