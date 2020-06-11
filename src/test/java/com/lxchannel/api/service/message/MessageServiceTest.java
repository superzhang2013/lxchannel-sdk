package com.lxchannel.api.service.message;


import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.dto.message.CodeMessageDTO;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.SignUtil;
import org.junit.Test;

/**
 * Created by Niki on 2019/5/21 16:39
 */
public class MessageServiceTest {

    @Test
    public void receiveMsg() {
        CodeMessageDTO code = new CodeMessageDTO();
        code.setType(8000);
        code.setTime(System.currentTimeMillis());
        code.setThird_uid("tuid8900123");
        code.setCode("dsoosdsfe52477895");
        JSONObject signparam = RequestParamUtil.postSignParam(code);
        signparam = signparam.getJSONObject("data");
        System.out.println(signparam);
        MessageService.receiveMsg(signparam);
    }
}
