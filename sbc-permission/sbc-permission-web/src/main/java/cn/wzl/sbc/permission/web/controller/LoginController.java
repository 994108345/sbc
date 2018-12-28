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
    public MessageResult login(@RequestBody UserInfo userInfo,HttpServletResponse response){
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
            /*存cookie，存redis，存一天*/
            try {
                /*token*/
                CookieUtil.set(response, CommonConstant.CookieConstant.TOKEN,token,CommonConstant.CookieConstant.LOGIN_OUT_TIME);
                /*userName*/
                CookieUtil.set(response, CommonConstant.CookieConstant.USERNAME,userInfo.getUserName(),CommonConstant.CookieConstant.USERNAME_OUT_TIME);
                redisUtil.addWithTime(token,"",1L, TimeUnit.HOURS);
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
        Cookie[] cookies = request.getCookies();
        /*循环cookie，找出token,从cookie中删除，从redis中删除*/
        boolean isCookie = false;
        try{
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if(!StringUtils.isBlank(name) && name.equals(CommonConstant.CookieConstant.TOKEN)){
                    String value = cookie.getValue();
                    if(StringUtils.isBlank(value)){
                        result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"cookie异常");
                        return result;
                    }else{
                        /*redis删除token*/
                        redisUtil.delByKey(value);
                        /*删除cookie*/
                        CookieUtil.delCookie(cookie);
                        response.addCookie(cookie);

                        isCookie = true;
                    }
                    break;
                }
            }
            if(!isCookie){
                throw new Exception("登出失败");
            }

        }catch (Exception e){
            log.error("loginController loginOut has a error",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"删除redis出错" + e.getMessage());
        }
        return result;
    }




}
