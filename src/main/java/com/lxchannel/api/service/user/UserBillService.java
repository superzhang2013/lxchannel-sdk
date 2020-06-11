package com.lxchannel.api.service.user;

import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.user.UserInfoReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;

/**
 * 查询用户账单
 * Created by Niki on 2019/5/21 15:57
 */
public class UserBillService extends BaseService {
    public Object userBill(UserInfoReq req) throws IOException {
        ValidUtil.checkParam(req);
        String getURL = RequestParamUtil.getParam(LxchannelConstants.USER_MONTH_BILL, req);
        return get(getURL);
    }
}
