package com.lxchannel.api.dto.order;

import com.lxchannel.api.dto.SignBaseReq;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用户费率试算请求对象
 * Created by Niki on 2019/5/14 10:07
 */
@Data
@ToString(callSuper = true)
public class UserRateReq extends SignBaseReq {
    @NotNull(message = "loadAmount 不能为空")
    private BigDecimal loadAmount;

    /**
     * 用户第三方id。之前为thirdUid，废弃该命名，采用openId
     */
    private String openId;

    private List<Integer> fqNums;

    /**
     * "贴息模式：0 - 不贴息（默认）；100 - 贴息
     */
    private Integer discountRatio;

    @NotNull(message = "agent 不能为空")
    private String agent;

}
