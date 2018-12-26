package cn.wzl.sbc.permission.service;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.permission.dao.bean.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/26 10:26
 * @doc UserInfoServiceImpl
 **/
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public MessageResult getUserInfo(UserInfo userInfo) {
        MessageResult result = new MessageResult();
        try {
            List<UserInfo> list = userDao.listUserInfoByCondition(userInfo);
            result.setData(list);
        } catch (Exception e) {
            log.error("userInfoService getUserInfo is error",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"获取用户信息失败"+e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult updatePasswordByuserName(UserInfo userInfo) {
        MessageResult result = new MessageResult();
        try {
            userDao.updatePasswordByCondition(userInfo);
        } catch (Exception e) {
            log.error("userInfoService updatePasswordByuserName is error",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"更新密码错误"+e.getMessage());
        }
        return result;
    }
}
