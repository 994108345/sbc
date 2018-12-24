package cn.wzl.sbc.permission.service.register;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.permission.service.register.bean.UserRegisterBean;

/**
 * @Author wzl
 * @Date 2018/12/24 15:52
 * @doc RegisterService
 **/
public interface RegisterService {

    /**
     * 注册用户
     * @return
     */
    MessageResult register(UserRegisterBean userRegisterBean);

    /**
     * 注册用户（加事务）
     * @param userRegisterBean
     */
    void registerUserInfo(UserRegisterBean userRegisterBean) throws Exception;
}
