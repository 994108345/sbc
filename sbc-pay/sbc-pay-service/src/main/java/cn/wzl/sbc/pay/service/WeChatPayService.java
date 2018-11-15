package cn.wzl.sbc.pay.service;


public interface WeChatPayService {
    /**
     * 接收支付通知
     * @param xml
     * @return
     */
    String getMethodFromWeChat(String xml);

    /**
     * 下单，调用微信接口
     * @return
     */
    String deliverOrder() throws Exception;

}
