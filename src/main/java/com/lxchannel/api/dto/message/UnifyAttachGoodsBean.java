package com.lxchannel.api.dto.message;

import lombok.Data;

/**
 * Created by zhanghong on 2020/6/4.
 */
@Data
public class UnifyAttachGoodsBean {

    private String third_subject;

    private String third_sku_id;

    private int goods_type;

    private int goods_quantity;

    private int is_pop;

    private String third_merch_id;
}
