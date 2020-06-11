package com.lxchannel.api;

/**
 * @Author: dogyu
 * @Date: 2018/10/29
 * @Description:
 */
public class LxchannelConstants {

    private LxchannelConstants() {
    }

    /**
     * sdk默认的数据传输格式：json
     */
    public final static String API_DEFAULT_FORMAT = "json";
    /**
     * api默认版本1.4
     */
    public final static String API_DEFAULT_VERSION = "1.4";

    /**
     * 获取access_token值url
     **/
    public final static String ACCESS_TOKEN_URL = "https://open.api.fenqile.com/route0007/oauth/access_token.json";

    /**
     * 刷新access_token值url
     **/
    public final static String REFRESH_TOKEN_URL = "https://open.api.fenqile.com/route0007/oauth/refresh_token.json";

    /**
     * 查询用户总额度以及用户授信时间，以及绑定agent和首次授信时间
     */
    public final static String USER_CREDIT_INFO = "https://open.api.fenqile.com/route0007/user/credit/query.json";

    /**
     * 用户月账单查询
     */
    public final static String USER_MONTH_BILL = "https://open.api.fenqile.com/route0007/user/bill/query.json";

    /**
     * 收银台利率试算接口
     **/
    public final static String USER_RATE = "https://open.api.fenqile.com/route0007/pop/loan/rate/trial.json";

    /**
     * 下单
     */
    public final static String PLAYC_ORDER_H5 = "https://open.api.fenqile.com/route0007/pop/order/reserve.json";
    public final static String PLAYC_ORDER_SDK = "https://open.api.fenqile.com/route0007/pop/order/sdk/reserve.json";

    /**
     * 查询订单信息
     */
    public final static String ORDER_QUERY = "https://open.api.fenqile.com/route0007/pop/order/query.json";

    /**
     * 部分退款
     */
    public final static String REFUND_ORDER = "https://open.api.fenqile.com/route0007/pop/order/refund/submit.json";

    /**
     * 查询部分退款
     */
    public final static String QUERY_REFUND_ORDER = "https://open.api.fenqile.com/route0007/pop/order/refund/query.json";

    /**
     * 关闭订单
     */
    public final static String CLOSE_ORDER = "https://open.api.fenqile.com/route0007/pop/order/notice.json";

    /**
     * sdk 接入统一下单
     */
    public final static String ORDER_SDK_UNIFY = "https://open.api.fenqile.com/route0007/pop/order/sdk/unify.json";

    /**
     * 微信小程序、微信公众号接入请求URL
     */
    public final static String ORDER_UNIFY = "https://open.api.fenqile.com/route0007/pop/order/unify.json";

}
