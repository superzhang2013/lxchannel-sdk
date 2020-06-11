package com.lxchannel.api.dto.order;

import com.lxchannel.api.dto.SignBaseReq;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 统一下单对象
 * Created by zhanghong on 2020/6/4.
 */
@Data
@ToString(callSuper = true)
public class UnifyOrderFinalReq extends SignBaseReq {

    /**
     * 加密字符串
     */
    @NotNull(message = "加密字符串不允许为空")
    private String encryptedData;

}
