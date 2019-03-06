package cn.wzl.sbc.common.util;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 11:34
 * @description：类对象工具类
 */
public class ClassUtil {

    /**
     * 获取指定方法对象
     * @return
     */
    public static Method getMethod(Class objClass,String methodName) throws Exception {
        Method[] methods = objClass.getMethods();
        if(objClass == null || StringUtils.isBlank(methodName)){
            throw new Exception("参数类类型和方法名不能为空");
        }
        for (Method method : methods) {
            if(methodName.equals(method.getName())){
                return method;
            }
        }
        return null;
    }

    /**
     * 获取指定的
     * @param method
     * @param method
     * @return
     */
    public static Class getParameterClass(Method method) throws Exception {
        Parameter[] parmeters = method.getParameters();
        if(method == null){
            throw new Exception("参数:方法对象不能为空");
        }
        for (Parameter parmeter : parmeters) {
            return parmeter.getType();
        }
        return null;
    }
}
