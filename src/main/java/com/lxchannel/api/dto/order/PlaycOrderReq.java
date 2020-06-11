package com.lxchannel.api.dto.order;

import com.lxchannel.api.dto.SignBaseReq;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 下单请求对象
 * Created by Niki on 2019/5/14 11:30
 */
@Data
@ToString(callSuper = true)
public class PlaycOrderReq extends SignBaseReq {
    /**
     * 订单金额，必须大于4.00元
     */
    @NotNull(message = "订单金额amount不允许为null")
    @Pattern(regexp="(^[1-9](\\d+)?(\\.\\d{1,2})?$)|(^0$)|(^\\d\\.\\d{1,2}$)", message = "订单金额格式不对,精确到分")
    @Min(value = 0, message = "订单金额amount必须大于0.00元")
    private String amount;

    /**
     * 第三方订单id
     */
    private String thirdOrderId;

    /**
     * 下单时间，格式 "yyyy-MM-dd HH:mm:ss"
     */
    @NotNull(message = "创建时间不允许为null")
    private String createTime;

    /**
     * 商品名称
     */
    @NotNull(message = "商品名称subject不允许为空")
    private String subject;

    /**
     * 风控用途相关信息，尽量传入有助于成交
     */
    @NotNull(message = "attach不允许为空")
    private String attach;

    /**
     * 交易的具体描述
     */
    private String body;
    /**
     * 订单允许的最晚付款时间
     */
    private String timeOutExpress;
    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 分期数
     */
    private Integer fqNums;

    /**
     * 支付场景-新乐卡支付流程
     */
    @NotNull(message = "应用场景scene不允许为null")
    @Pattern(regexp = "^(1|2)$", message = "应用场景scene：1 - 支付场景；2 - 开户场景")
    private String scene;

    /**
     * 商户是否贴息
     */
    @Pattern(regexp = "^(0|100)$", message = "贴息模式discountRatio：0 - 不贴息（默认）；100 - 贴息")
    private String discountRatio;

    /**
     * 商户是否自动创建账单，默认不自动创建
     */
    @Pattern(
            regexp = "^(0|1)$",
            message = "贴息模式：0 - 不自动生成（默认）；1 - 自动生成"
    )
    private String autoCreate = "0";

    /**
     * 商户接受订单回调消息地址
     */
    private String receiveMsgUrl;

    /**
     * agent，用于新用户授信绑码
     */
    @NotNull(message = "渠道agent不允许为null")
    private String agent;

    /**
     * 商户id
     */
    @NotNull(message = "clientId不允许为null")
    private String clientId;

    /**
     * 第三方用户id
     */
    @NotNull(message = "用户thirdUid不允许为null")
    private String thirdUid;

    /**
     * 用于新用户的免密注册
     */
    private String phone;

    /**
     * 商户的业务场景
     * 0：正常业务类型 默认值；1：押金类业务
     */
    private String businessType = "0";

    /**
     * 收银台主题颜色，可为空
     * #dadee6
     */
    private String themeColor;

}
