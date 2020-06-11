package com.lxchannel.api.exception;

import lombok.AllArgsConstructor;

/**
 * Created by Niki on 2019/5/14 10:39
 */
@AllArgsConstructor
public class BusinessException  extends RuntimeException{
    private String code;
    private String msg;


    @Override
    public String getMessage() {
        return this.code + ": " + this.msg;
    }
}
