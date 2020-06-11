package com.lxchannel.api.dto.message;

import lombok.Data;

/**
 * 统一下单 加密前的业务参数
 * Created by zhanghong on 2020/6/4.
 */
@Data
public class UnifyOrderMessageDTO {

    /**
     * 流程场景
     */
    private String scene;


    /**
     * 商户订单支付流水号
     */
    private String third_order_id;


    /**
     * 订单金额
     */
    private String amount;

    /**
     * 用户在商户收银台选中的分期数
     */
    public int fq_nums;

    /**
     * 下单时间，格式"yyyy-MM-dd HH:mm:ss"
     */
    private String create_time;

    /**
     * 商品名称 使用UTF-8编码
     */
    private String subject;

    /**
     * json格式 的附件内容
     */
    private String attach;

    /**
     *该笔订单允许的最晚付款时间，逾期将关闭交易。可选的值见本表格。m为分钟。该参数数值不接受小数点。
     */
    private String time_out_express;

    //客户端ip
    private String client_ip;

    //商户是否贴息
    private String discount_ratio;

    //自动生成账单
    private String auto_create;

    //商户用来接收该订单消息的回调地址
    private String receive_msg_url;

    //商户client_id ，由分期乐提供。
    private String client_id;

    //用户在商户侧唯一id
    private String third_uid;

    //用户在商户平台的绑定手机号，用于免密注册分期乐
    private String phone;

    //渠道码标识，由分期乐提供
    private String agent;
}
