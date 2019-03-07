package cn.wzl.sbc.common.util;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/7 17:31
 * @description：
 */
public class MessageUtil {

    public static PageBeanResult messageToPage(MessageResult result){
        PageBeanResult pageBeanResult = new PageBeanResult();
        pageBeanResult.setMessage(result.getMessage());
        pageBeanResult.setStatus(result.getStatus());
        pageBeanResult.setData(result.getData());
        return pageBeanResult;
    }

    public static MessageResult pageToMessage(PageBeanResult param){
        MessageResult result = new MessageResult();
        result.setMessage(param.getMessage());
        result.setStatus(param.getStatus());
        result.setData(param.getData());
        return result;
    }
}
