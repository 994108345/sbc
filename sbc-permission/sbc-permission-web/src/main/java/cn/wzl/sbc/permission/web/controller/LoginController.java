package cn.wzl.sbc.permission.web.controller;

import cn.wzl.sbc.common.annotation.LogAccept;
import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.constant.LogAcceptConstant;
import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.CookieUtil;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.common.util.UuidUtil;
import cn.wzl.sbc.permission.service.login.LoginService;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.common.result.MessageResult;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @Author wzl
 * @Date 2018/12/13 19:32
 * @doc LoginController
 **/
@RestController
@RequestMapping("sbc-permission/Login")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private LoginService loginService;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 登陆
     * @param userInfo
     * @return
     */
    @LogAccept(modleName = LogAcceptConstant.ModelName.LOG,actionName = LogAcceptConstant.actionName.LOG)
    @PostMapping("login")
    @ResponseBody
    public MessageResult login(@RequestBody UserInfo userInfo,HttpServletResponse response,HttpServletRequest request){
        MessageResult result = new MessageResult();
        /*参数校验*/
        if(StringUtils.isBlank(userInfo.getUserName())){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"账号不能为空");
            return result;
        }
        if(StringUtils.isBlank(userInfo.getPassWord())){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"密码不能为空");
            return  result;
        }
        result = loginService.login(userInfo);
        /*如果登录成功，生成token存进redis和cookie*/
        if(result.isSuccess()){
            /*生成token*/
            String token = UuidUtil.getUuidNoLine();
            UserInfo user = (UserInfo) result.getData();
            /*将密码置空，不能存到session中*/
            user.setPassWord(null);
            /*存cookie，存redis，存一小时*/
            try {
                /*token存cookie*/
                CookieUtil.set(response,CommonConstant.CookieConstant.TOKEN,token,CommonConstant.CookieConstant.LOGIN_OUT_TIME);
                /*token存redis*/
                redisUtil.addWithTime(token,user.getUserName(),RedisConstant.RedisOutTimes.TOKEN_OUT_TIME, TimeUnit.HOURS);
                /*userName存session*/
                /*将usre转成json字符串*/
                String userStr = JSONObject.toJSONString(user);
                redisUtil.addWithTime(user.getUserName(), userStr,RedisConstant.RedisOutTimes.TOKEN_OUT_TIME,TimeUnit.HOURS);
            } catch (Exception e) {
                log.error(String.format("redis存储失败-账号为:%s,错误信息为:%s",userInfo.toString(),e.getMessage()),e);
            }
        }
        return result;
    }

    /**
     * 注销（登出）
     * @param userInfo
     * @param request
     * @param response
     * @return
     */
    @LogAccept(modleName = LogAcceptConstant.ModelName.LOG,actionName = LogAcceptConstant.actionName.LOG_OUT)
    @PostMapping("loginOut")
    @ResponseBody
    public MessageResult loginOut(@RequestBody UserInfo userInfo,HttpServletRequest request,HttpServletResponse response){
        MessageResult result = new MessageResult();
        try{
            Cookie cookie = CookieUtil.get(request, CommonConstant.CookieConstant.TOKEN);
            String token = cookie.getValue();
            /*判断token是否一样*/
            if(token == null){
                result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"Cookie中的token不合法");
                return result;
            }
            String userName = (String)redisUtil.getByKey(token);
            if(userName == null){
                throw new Exception("token不存在");
            }
            /*token存在，说明合法，删除Cookie中的token，redis中的token，userName*/
            redisUtil.delByKey(token);
            redisUtil.delByKey(userName);
            CookieUtil.delCookie(request, CommonConstant.CookieConstant.TOKEN);
        }catch (Exception e){
            log.error("loginController loginOut has a error",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"删除redis出错" + e.getMessage());
        }
        return result;
    }




}
