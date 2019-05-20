package cn.wzl.sbc.permission.web.controller.web;

import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.constant.JsonConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.ClassUtil;
import cn.wzl.sbc.common.util.ObjectTranUtil;
import cn.wzl.sbc.common.util.SpringBeanUtil;
import cn.wzl.sbc.model.permission.UserInfo;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 10:47
 * @description：代理controller层，调用service层
 */
@RequestMapping(value = "/sbc-permission/New")
@RestController
public class PermissionWeb {

    private Logger log = LoggerFactory.getLogger(PermissionWeb.class);

    /**
     * 走权限
     * @param obj
     * @param userNameStr
     * @param serviceName
     * @param method
     * @return
     */
    @PostMapping("web/{serviceName}/{method}")
    @ResponseBody
    public Object webPost(@RequestBody Object obj ,
                                   @RequestAttribute(value = CommonConstant.RequestConstant.USERINFO_STR) String userNameStr,
                                   @PathVariable("serviceName")String serviceName,
                                   @PathVariable("method")String method){
        MessageResult result = new MessageResult();
        if(obj == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"参数不能为空");
            return result;
        }
        if(StringUtils.isBlank(serviceName)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"service不能为空");
            return result;
        }
        if(StringUtils.isBlank(method)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"method不能为空");
            return result;
        }
        if(StringUtils.isBlank(userNameStr)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"用户信息不能为空");
            return result;
        }
        /*转换对象*/
        UserInfo userInfo = JSONObject.parseObject(userNameStr,UserInfo.class);
        /*去空字符串*/
        obj = ObjectTranUtil.emptyToNullOfObj(obj);
        Object bean = SpringBeanUtil.getBean(serviceName);
        Class serviceClass = bean.getClass();
        try {
            /*获取方法*/
            Method serviceMethod = ClassUtil.getMethod(serviceClass,method);
            if(serviceMethod == null){
                throw new Exception("匹配不到对应方法");
            }
            /*获取方法参数类型*/
            Class parmeterClass = ClassUtil.getParameterClass(serviceMethod);
            if(parmeterClass == null){
                throw new Exception("该方法没有入参");
            }
            String jsonStr = JSONObject.toJSONString(obj);
            /*给请求参数加人用户信息*/
            JSONObject jsonObj = JSONObject.parseObject(jsonStr);
            jsonObj.put(JsonConstant.UserInfo.USRINFO_USERNAME,userInfo.getUserName());
            jsonObj.put(JsonConstant.UserInfo.USRINFO_ID,userInfo.getId());
            jsonObj.put(JsonConstant.UserInfo.USRINFO_USERCODE,userInfo.getUserCode());
            jsonObj.put(JsonConstant.UserInfo.USRINFO_PASSWORD,userInfo.getPassWord());

            String param = JSONObject.toJSONString(jsonObj);
            Object paramObj =JSONObject.parseObject(param ,parmeterClass);
            /*调用目标方法*/
            Object returnParam = serviceMethod.invoke(SpringBeanUtil.getBean(serviceName),paramObj);
            return returnParam;
        } catch (Exception e) {
            log.error("ProdWeb webConfig has error ......",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @GetMapping("web/{serviceName}/{method}")
    @ResponseBody
    public Object webGetPost(@RequestBody Object obj ,
                          @RequestAttribute(value = CommonConstant.RequestConstant.USERINFO_STR) String userNameStr,
                          @PathVariable("serviceName")String serviceName,
                          @PathVariable("method")String method){
        MessageResult result = new MessageResult();
        if(obj == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"参数不能为空");
            return result;
        }
        if(StringUtils.isBlank(serviceName)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"service不能为空");
            return result;
        }
        if(StringUtils.isBlank(method)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"method不能为空");
            return result;
        }
        if(StringUtils.isBlank(userNameStr)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"用户信息不能为空");
            return result;
        }
        /*转换对象*/
        UserInfo userInfo = JSONObject.parseObject(userNameStr,UserInfo.class);
        /*去空字符串*/
        obj = ObjectTranUtil.emptyToNullOfObj(obj);
        Object bean = SpringBeanUtil.getBean(serviceName);
        Class serviceClass = bean.getClass();
        try {
            /*获取方法*/
            Method serviceMethod = ClassUtil.getMethod(serviceClass,method);
            if(serviceMethod == null){
                throw new Exception("匹配不到对应方法");
            }
            /*获取方法参数类型*/
            Class parmeterClass = ClassUtil.getParameterClass(serviceMethod);
            if(parmeterClass == null){
                throw new Exception("该方法没有入参");
            }
            String jsonStr = JSONObject.toJSONString(obj);
            /*给请求参数加人用户信息*/
            JSONObject jsonObj = JSONObject.parseObject(jsonStr);
            jsonObj.put(JsonConstant.UserInfo.USRINFO_USERNAME,userInfo.getUserName());
            jsonObj.put(JsonConstant.UserInfo.USRINFO_ID,userInfo.getId());
            jsonObj.put(JsonConstant.UserInfo.USRINFO_USERCODE,userInfo.getUserCode());
            jsonObj.put(JsonConstant.UserInfo.USRINFO_PASSWORD,userInfo.getPassWord());

            String param = JSONObject.toJSONString(jsonObj);
            Object paramObj =JSONObject.parseObject(param ,parmeterClass);
            /*调用目标方法*/
            Object returnParam = serviceMethod.invoke(SpringBeanUtil.getBean(serviceName),paramObj);
            return returnParam;
        } catch (Exception e) {
            log.error("ProdWeb webConfig has error ......",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    /**
     * 不走权限
     * @param obj
     * @param serviceName
     * @param method
     * @return
     */
    @PostMapping("webNo/{serviceName}/{method}")
    @ResponseBody
    public Object webPostNoPermission(@RequestBody Object obj ,
                          @PathVariable("serviceName")String serviceName,
                          @PathVariable("method")String method){
        MessageResult result = new MessageResult();
        if(obj == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"参数不能为空");
            return result;
        }
        if(StringUtils.isBlank(serviceName)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"service不能为空");
            return result;
        }
        if(StringUtils.isBlank(method)){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"method不能为空");
            return result;
        }
        /*去空字符串*/
        obj = ObjectTranUtil.emptyToNullOfObj(obj);
        Object bean = SpringBeanUtil.getBean(serviceName);
        Class serviceClass = bean.getClass();
        try {
            /*获取方法*/
            Method serviceMethod = ClassUtil.getMethod(serviceClass,method);
            if(serviceMethod == null){
                throw new Exception("匹配不到对应方法");
            }
            /*获取方法参数类型*/
            Class parmeterClass = ClassUtil.getParameterClass(serviceMethod);
            if(parmeterClass == null){
                throw new Exception("该方法没有入参");
            }
            String jsonStr = JSONObject.toJSONString(obj);
            /*给请求参数加人用户名*/
            JSONObject jsonObj = JSONObject.parseObject(jsonStr);
            String param = JSONObject.toJSONString(jsonObj);
            Object paramObj =JSONObject.parseObject(param ,parmeterClass);
            /*调用目标方法*/
            Object returnParam = serviceMethod.invoke(SpringBeanUtil.getBean(serviceName),paramObj);
            return returnParam;
        } catch (Exception e) {
            log.error("ProdWeb webConfig has error ......",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @PostMapping("webNo/pictureUpload")
    public MessageResult pictureUpload(HttpServletRequest request){
        MessageResult result = new MessageResult();


        return result;
    }

}
