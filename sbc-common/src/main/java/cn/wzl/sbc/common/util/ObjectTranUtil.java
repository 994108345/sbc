package cn.wzl.sbc.common.util;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/**
 * @Author wzl
 * @Date 2018/12/18 17:59
 * @doc ObjectTranUtil
 **/
public class ObjectTranUtil {

    private static final Logger log = LoggerFactory.getLogger(ObjectTranUtil.class);

    /**
     * 对象中的属性如果为空字符串(""),则转成null(只针对普通类型，暂时不支持数组和集合)
     * @param param 需要判断的数据
     * @throws IllegalAccessException
     */
    public static MessageResult emptyToNull(Object param){
        MessageResult result = new MessageResult();
        /*获取对象的类类型*/
        Class classInfo = param.getClass();
        /*获取字段集合*/
        Field[] declaredFields = classInfo.getDeclaredFields();
        try{
            /*循环字段，取值判断*/
            for (Field field : declaredFields) {
                /*设置可以访问private属性*/
                field.setAccessible(true);
                /*取字段值*/
                Object value = field.get(param);
                /*判断字段值*/
                if(value !=null && StringUtils.isEmpty(String.valueOf(value))){
                    field.set(param,null);
                }
            }
        }catch(Exception e){
            log.error("ObjectTranUtil emptyToNull has error",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"对象转换失败");
        }
        return result;
    }

    /**
     * 对象中的属性如果为空字符串(""),则转成null(只针对普通类型，暂时不支持数组和集合)
     * @param param 需要判断的数据
     * @throws IllegalAccessException
     */
    public static Object emptyToNullOfObj(Object param){
        /*获取对象的类类型*/
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(param));
        Set<Map.Entry<String, Object>> set =  jsonObject.entrySet();
        for (Map.Entry<String, Object> stringObjectEntry : set) {
            String key = stringObjectEntry.getKey();
            Object value = jsonObject.get(key);
            if(value != null && "".equals(String.valueOf(value))){
                jsonObject.put(key,null);
            }
        }
        Object result = JSONObject.parse(jsonObject.toJSONString());
        return result;
    }
}
