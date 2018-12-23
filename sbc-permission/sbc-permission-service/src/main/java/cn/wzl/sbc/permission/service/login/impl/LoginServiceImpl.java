package cn.wzl.sbc.permission.service.login.impl;

import cn.wzl.sbc.common.util.Md5Util;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.permission.service.login.LoginService;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.permission.dao.bean.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/13 18:54
 * @doc LoginServiceImpl
 **/
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    private final static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private UserDao userDao;
    @Override
    public MessageResult login(UserInfo userInfo) {
        MessageResult result = new MessageResult();
        try {
            /*将密码转成mod5再查询*/
            String password = Md5Util.EncoderByMd5(userInfo.getPassWord());
            userInfo.setPassWord(password);
            /*查询*/
            List<UserInfo> users = userDao.listUserInfoByCondition(userInfo);
            if(users == null){
                result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"返回参数为null");
            }
            if(users.size() < 1){
                result.setMessageByResultEnum(ReturnResultEnum.LOGIN_ERROR);
            }
        } catch (Exception e) {
            log.error("登陆错误" + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"登陆错误：" + e.getMessage());
        }
        return result;
    }
}
