package cn.wzl.sbc.pay.service.impl;



import common.util.XmlUtils;
import domain.Order;
import domain.OrderToWeChat;
import domain.WeChatRequest;
import domain.WeChatRtn;
import org.springframework.stereotype.Service;
import cn.wzl.sbc.pay.service.WeChatPayService;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

@Service("weChatPayService")
public class WeChatPayServiceImpl implements WeChatPayService {

    /**
     * 调用微信接口下单
     * @return
     */
    public String deliverOrder() throws Exception {
        try{
            OrderToWeChat orderToWeChat = this.joinOrder();
            String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
            String requestMethod = "POST";
            String requestProperty1 = "Content-type";
            String requestProperty2 = "text/xml";
            boolean isRedirects = false;
            System.out.println("传参为："+XmlUtils.convertToXml(orderToWeChat));
            /**获得HttpURLConnection*/
            HttpsURLConnection conn = getHttpUrlConnection(url,requestMethod,requestProperty1,requestProperty2,isRedirects,XmlUtils.convertToXml(orderToWeChat));
            /**发起https请求调用微信的接口*/
            String retStr = getReturn(conn);
            WeChatRtn weCharRtn = (WeChatRtn) XmlUtils.convertXmlStrToObject(WeChatRtn.class,retStr);
            System.out.println("调用微信接口返回信息为："+weCharRtn.toString());
            return retStr;
        }catch (Exception e){
            System.out.println("调用微信接口下单发生异常:" + e.getMessage());
            throw new Exception("调用微信接口出错" + e.getMessage());
        }
    }

    /**
     * 微信回调方法，返回订单转账信息
     * @param xml
     * @return
     */
    public String  getMethodFromWeChat(String xml){
        WeChatRequest weChatRequest = (WeChatRequest) XmlUtils.convertXmlStrToObject(WeChatRequest.class,xml);
        System.out.println("接收到微信的回调参数为:"+ xml);
        WeChatRequest request = new WeChatRequest();
        request.setResult_code("SUCCESS");
        request.setReturn_msg("OK");
        String rtnMsg = XmlUtils.convertToXml(request);
        return rtnMsg;
    }

    /**
     * 保存订单
     * @return
     */
    public Object saveOrder(Order order){
        System.out.println("保存订单信息："+order.toString());
        return true;
    }

    /**
     * 获得HttpUrlConnection
     * @param url
     * @param requestMethod
     * @param requestProperty1
     * @param requestProperty2
     * @param isRedirects
     * @return
     * @throws IOException
     */
    public HttpsURLConnection getHttpUrlConnection(String url, String requestMethod, String requestProperty1, String requestProperty2, boolean isRedirects, String xmlParam) throws IOException {
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        HttpsURLConnection conn = null;
        try{
            URL serverUrl = new URL(url);
            conn = (HttpsURLConnection) serverUrl.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty(requestProperty1, requestProperty2);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //必须设置false，否则会自动redirect到重定向后的地址
            conn.setInstanceFollowRedirects(isRedirects);
            outputStream = conn.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(xmlParam);
            outputStreamWriter.flush();
            conn.connect();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            /**关闭资源*/
            if(outputStream != null){
                outputStream.close();
            }
            if(outputStreamWriter != null){
                outputStreamWriter.close();
            }
        }
        return conn;
    }


    /**
     *  发起https请求
     */
    public static String getReturn(HttpsURLConnection connection) throws Exception {
        StringBuffer buffer = new StringBuffer("");
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String result = "";
        //将返回的输入流转换成字符串
        try{
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            result = buffer.toString();
            System.out.println("缓存结果："+result);
            return result;
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }finally {
            /**关闭资源*/
            if(inputStream != null){
                inputStream.close();
            }
            if(inputStreamReader != null){
                inputStreamReader.close();
            }
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
    }

    /**
     * 组合下单的订单信息
     * @return
     */
    public OrderToWeChat joinOrder(){
        OrderToWeChat order = new OrderToWeChat();
        order.setAppid("wxd678efh567hg6787");
        order.setMch_id("1230000109");
        order.setDevice_info("WEB");
        order.setNonce_str("5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
        order.setSign("C380BEC2BFD727A4B6845133519F3AD6");
        order.setSign_type("HMAC-SHA256");
        order.setBody("腾讯充值中心-QQ会员充值");
        order.setDevice_info("");
        order.setAttach("深圳分店");
        order.setOut_trade_no("20150806125346");
        order.setFee_type("CNY");
        order.setTotal_fee(Integer.parseInt("888"));
        order.setSpbill_create_ip("123.12.12.123");
        order.setTime_start("20091225091010");
        order.setTime_expire("20091227091010");
        order.setGoods_tag("WXG");
        order.setNotify_url("http://www.weixin.qq.com/wxpay/pay.php");
        order.setTrade_type("MWEB");
        order.setProduct_id("12235413214070356458058");
        order.setLimit_pay("no_credit");
        order.setOpenid("oUpF8uMuAJO_M2pxb1Q9zNjWeS6o");
        order.setScene_info("{\"h5_info\": \"h5_info\" \n" +
                "   {\"type\": \"场景类型\",\n" +
                "    \"wap_url\": \"//WAP网站URL地址\",\n" +
                "    \"wap_name\": \"//WAP 网站名\" \n" +
                "    }\n" +
                "}");
        return order;
    }

    /**
     * 生成签名
     * @param key
     */
    public void getSign(String key){

    }

}
