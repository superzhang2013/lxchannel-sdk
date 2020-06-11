package com.lxchannel.api.service.user;

import com.lxchannel.api.LxchannelConstants;
import com.lxchannel.api.dto.user.UserInfoReq;
import com.lxchannel.api.service.BaseService;
import com.lxchannel.api.util.RequestParamUtil;
import com.lxchannel.api.util.ValidUtil;

import java.io.IOException;

/**
 * Created by Niki on 2019/5/14 14:18
 */
public class UserCreditService extends BaseService {
    /**
     * 查询用户的额度
     * @param req
     * @return
     */
    public Object userCredit(UserInfoReq req) throws IOException {
        ValidUtil.checkParam(req);
        String getURL = RequestParamUtil.getParam(LxchannelConstants.USER_CREDIT_INFO, req);
        return get(getURL);
    }
}
