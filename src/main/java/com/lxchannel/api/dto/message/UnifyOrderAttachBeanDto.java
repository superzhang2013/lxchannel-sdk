package com.lxchannel.api.dto.message;

import lombok.Data;

import java.util.List;

/**
 * Created by zhanghong on 2020/6/4.
 */
@Data
public class UnifyOrderAttachBeanDto {

    private String third_uid;

    private int register_time;

    private List<UnifyAttachGoodsBean> goods_list;

    private String name;

    private String phone;

    private String address;

    private String account;
}
