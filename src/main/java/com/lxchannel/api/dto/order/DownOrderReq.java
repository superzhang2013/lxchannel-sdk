package com.lxchannel.api.dto.order;

import com.lxchannel.api.dto.SignBaseReq;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * User: lujunnan
 * Date: 2020/6/11
 * Time: 12:01
 * Description: 下载对账单请求体
 */
@Data
public class DownOrderReq extends SignBaseReq {

    @NotNull(message = "查询时间不允许为空")
    String day;
}
