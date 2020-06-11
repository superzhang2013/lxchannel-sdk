package com.lxchannel.api.dto.message;

import lombok.Data;

/**
 * 用户code消息内容
 * Created by Niki on 2019/5/21 16:15
 */
@Data
public class CodeMessageDTO extends BaseMessageDTO {
    /**
     * 商户侧用户id
     */
    private String third_uid;

    private String code;


}
