package cn.wzl.sbc.permission.service.register.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.model.permission.UserQuestion;
import cn.wzl.sbc.permission.dao.bean.UserDao;
import cn.wzl.sbc.permission.dao.bean.UserQuestionDao;
import cn.wzl.sbc.permission.service.login.LoginService;
import cn.wzl.sbc.permission.service.register.RegisterService;
import cn.wzl.sbc.permission.service.register.bean.UserRegisterBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/24 15:53
 * @doc RegisterServiceImpl
 **/
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    private static final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Resource
    private LoginService loginService;

    @Resource
    private UserQuestionDao userQuestionDao;

    @Resource
    private RegisterService registerService;

    @Override
    public MessageResult register(UserRegisterBean userRegisterBean) {
        MessageResult result = new MessageResult();
        UserInfo userInfo = userRegisterBean.getUserInfo();
        /*先判断账号是否重复*/
        UserInfo queryUser = new UserInfo();
        queryUser.setUserName(userInfo.getUserName());
        try {
            List<UserInfo> userInfoList = userDao.listUserInfoByCondition(queryUser);
            if(userInfoList.size() > 0){
                throw new Exception("账号已存在");
            }
            /*调用注册方法，*/
            registerService.registerUserInfo(userRegisterBean);
        } catch (Exception e) {
            log.error("注册失败：" + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"注册失败：" + e.getMessage());
        }
        return result;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void registerUserInfo(UserRegisterBean userRegisterBean) throws Exception {
        List<UserQuestion> questionList = userRegisterBean.getQuestions();
        UserInfo userInfo = userRegisterBean.getUserInfo();
        /*添加用户信息*/
        MessageResult addUserResult = loginService.addUser(userInfo);
        if(addUserResult.isError()){
            throw new Exception(addUserResult.getMessage());
        }
        /*插入问题集合*/
        userQuestionDao.insertByBatch(questionList);
    }
}
