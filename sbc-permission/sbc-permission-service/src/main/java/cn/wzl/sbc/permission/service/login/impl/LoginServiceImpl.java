package cn.wzl.sbc.permission.service.login.impl;

import cn.wzl.sbc.common.constant.CommonConstant;
import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.util.CodeUtil;
import cn.wzl.sbc.common.util.Md5Util;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.model.permission.UserInfoDtl;
import cn.wzl.sbc.permission.dao.mapper.UserInfoDtlMapper;
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
    private CodeUtil codeUtil;

    @Resource
    private UserDao userDao;

    @Resource
    private UserInfoDtlMapper userInfoDtlMapper;

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
            }else{
                result.setData(users.get(0));
            }
        } catch (Exception e) {
            log.error("登陆错误" + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"登陆错误：" + e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult addUser(UserInfo userInfo) {
        MessageResult result = new MessageResult();
        try {
            /*用md5给密码加密*/
            String password = Md5Util.EncoderByMd5(userInfo.getPassWord());
            userInfo.setPassWord(password);
            int count = userDao.insertOneUserInfo(userInfo);
            String code = codeUtil.createCodeByRedis(RedisConstant.RedisCreateCode.CodeType.USER_INFO_DTL_CODE);
            //插入用户明细信息
            UserInfoDtl userInfoDtl = new UserInfoDtl();
            userInfoDtl.setUserInfoDtlCode(code);
            userInfoDtl.setStatus(CommonConstant.UserStatus.USEFUL);
            userInfoDtlMapper.insertByData(userInfoDtl);
        } catch (Exception e) {
            log.error("添加用户出错：" + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"添加用户出错：" + e.getMessage());
        }
        return result;
    }

    @Override
    public PageBeanResult queryByRequest(UserInfoDtl userInfoDtl) {
        PageBeanResult result = new PageBeanResult();
        try {
            List<UserInfoDtl> list = userInfoDtlMapper.queryUserInfos(userInfoDtl);
            result.setData(list);
        } catch (Exception e) {
            result.setErrorMessage("查询用户明细信息列表出现异常");
            log.error("LoginServiceImpl queryByRequest has error",e);
        }
        return result;
    }

    @Override
    public MessageResult updateUserInfo(UserInfoDtl userInfoDtl) {
        MessageResult result = new MessageResult();
        try {
            int count = userInfoDtlMapper.updateByCode(userInfoDtl);
        } catch (Exception e) {
            result.setErrorMessage("更新用户明细信息出现异常");
            log.error("LoginServiceImpl updateUserInfo has error",e);
        }
        return result;
    }

    @Override
    public MessageResult deleteByRequest(UserInfoDtl userInfoDtl) {
        MessageResult result = new MessageResult();
        try {
            int count = userInfoDtlMapper.deleteByRequest(userInfoDtl);
        } catch (Exception e) {
            result.setErrorMessage("删除用户明细信息出现异常");
            log.error("LoginServiceImpl deleteByRequest has error",e);
        }
        return result;
    }
}
