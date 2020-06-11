package com.lxchannel.api.service.order;

import com.alibaba.fastjson.JSONObject;
import com.lxchannel.api.BusinessProperties;
import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.message.UnifyAttachGoodsBean;
import com.lxchannel.api.dto.message.UnifyOrderAttachBeanDto;
import com.lxchannel.api.dto.message.UnifyOrderMessageDTO;
import com.lxchannel.api.dto.order.UnifyOrderFinalReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.AESUtil;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 统一下单 service
 * Created by zhanghong on 2020/6/4.
 */
public class UnifyOrderService extends BaseService {

    public static Object unifySdkOrder(UnifyOrderFinalReq unifyOrderFinalReq) throws IOException {
        ValidUtil.checkParam(unifyOrderFinalReq);
        JSONObject param = RequestParamUtil.postSignParam(unifyOrderFinalReq);
        return post(LxchannelConstants.ORDER_SDK_UNIFY, param);
    }

    public static Object unifyOrder(UnifyOrderFinalReq unifyOrderFinalReq) throws IOException {
        ValidUtil.checkParam(unifyOrderFinalReq);
        JSONObject param = RequestParamUtil.postSignParam(unifyOrderFinalReq);
        return post(LxchannelConstants.ORDER_UNIFY, param);
    }

    public static void main(String[] args) {
        UnifyOrderMessageDTO msgDto = new UnifyOrderMessageDTO();
        msgDto.setScene("1");
        msgDto.setThird_order_id("YH20171031183837528");
        msgDto.setAmount("2225.31");
        msgDto.setFq_nums(1);
        msgDto.setCreate_time("2018-01-03 17:56:48");
        msgDto.setSubject("Apple iPhone X 国行 全网通 黑色 256G");
        msgDto.setAuto_create("1");
        msgDto.setReceive_msg_url("http://www-test.tanzhoue.com/orderreceive");
        msgDto.setClient_id(BusinessProperties.CLINET_ID);
        msgDto.setThird_uid("25568856");
        msgDto.setPhone("15216151367");
        msgDto.setAgent(BusinessProperties.AGENT);

        UnifyOrderAttachBeanDto attachBeanDto = new UnifyOrderAttachBeanDto();
        attachBeanDto.setThird_uid("25568856");
        attachBeanDto.setRegister_time(2);
        attachBeanDto.setName("superzhangtest");
        attachBeanDto.setPhone("15216151367");
        attachBeanDto.setAddress("广州市天河区广场");

        List<UnifyAttachGoodsBean> goodsBeans = new ArrayList<UnifyAttachGoodsBean>();
        UnifyAttachGoodsBean goodsBean = new UnifyAttachGoodsBean();
        goodsBean.setThird_subject("Apple iPhone X 国行 全网通 黑色 256G");
        goodsBean.setThird_sku_id("28642482293");
        goodsBean.setGoods_type(1);
        goodsBean.setGoods_quantity(1);
        goodsBean.setIs_pop(0);
        goodsBeans.add(goodsBean);
        attachBeanDto.setGoods_list(goodsBeans);

        msgDto.setAttach(JSONObject.toJSONString(attachBeanDto));

        String jsonString = JSONObject.toJSONString(msgDto);
        String encrptData = AESUtil.stringEncrypt(jsonString, BusinessProperties.PARTNER_KEY);
        System.out.println("request json string " + jsonString);

        UnifyOrderFinalReq unifyOrderFinalReq = new UnifyOrderFinalReq();
        UnifyOrderFinalReq.init(unifyOrderFinalReq);
        //需要进行排序sign
        unifyOrderFinalReq.setEncryptedData(encrptData);
        System.out.println("request final json is " + JSONObject.toJSONString(unifyOrderFinalReq));

//        JSONObject param = RequestParamUtil.postSignParam(unifyOrderFinalReq);
//        System.out.println(JSONObject.toJSONString(param));
        try {
            Object object = unifySdkOrder(unifyOrderFinalReq);
            System.out.println(JSONObject.toJSONString(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
