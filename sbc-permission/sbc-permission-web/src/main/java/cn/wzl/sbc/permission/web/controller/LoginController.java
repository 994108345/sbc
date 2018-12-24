package cn.wzl.sbc.permission.web.controller;

import cn.wzl.sbc.common.constant.CommonConstant;
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
    @PostMapping("login")
    @ResponseBody


    public MessageResult login(@RequestBody UserInfo userInfo,HttpServletRequest request,HttpServletResponse response){
        MessageResult result = new MessageResult();
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
                CookieUtil.set(response, CommonConstant.CookieConstant.LOGIN_NAME,token,CommonConstant.CookieConstant.LOGIN_OUT_TIME);
                redisUtil.addWithTime(token,"",1L, TimeUnit.HOURS);
            } catch (Exception e) {
                log.error(String.format("redis存储失败-账号为:%s,错误信息为:%s",userInfo.toString(),e.getMessage()),e);
            }
        }
        return result;
    }
}
