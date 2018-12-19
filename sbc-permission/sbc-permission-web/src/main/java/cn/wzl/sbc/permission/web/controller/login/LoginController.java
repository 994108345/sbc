package cn.wzl.sbc.permission.web.controller.login;

import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.permission.service.login.LoginService;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.common.result.MessageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2018/12/13 19:32
 * @doc LoginController
 **/
@RestController
@RequestMapping("sbc-permission/Login")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * 登陆
     * @param userInfo
     * @return
     */
    @PostMapping("login")
    @ResponseBody
    public MessageResult login(@RequestBody UserInfo userInfo){
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
        return result;
    }
}
