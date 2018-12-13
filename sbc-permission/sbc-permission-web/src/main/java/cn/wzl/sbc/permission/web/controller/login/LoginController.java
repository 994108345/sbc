package cn.wzl.sbc.permission.web.controller.login;

import cn.wzl.sbc.permission.service.login.LoginService;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.common.result.MessageResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author wzl
 * @Date 2018/12/13 19:32
 * @doc LoginController
 **/
@RestController
@RequestMapping("Login")
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
        MessageResult result = loginService.login(userInfo);
        return result;
    }
}
