package cn.wzl.sbc.permission.service.reset.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.Md5Util;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.model.permission.UserQuestion;
import cn.wzl.sbc.permission.dao.bean.UserQuestionDao;
import cn.wzl.sbc.permission.service.UserInfoService;
import cn.wzl.sbc.permission.service.reset.ResetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wzl
 * @Date 2018/12/25 19:30
 * @doc ResetServiceImpl
 **/
@Service("resetService")
public class ResetServiceImpl implements ResetService {

    private static final Logger log = LoggerFactory.getLogger(ResetServiceImpl.class);

    @Resource
    private UserQuestionDao userQuestionDao;
    @Resource
    private UserInfoService userInfoService;

    @Override
    public MessageResult getUserQuestion(UserQuestion param) {
        MessageResult result = new MessageResult();
        try {
            List<UserQuestion> queryList =  userQuestionDao.queryByCondition(param);
            if(queryList == null){
                throw new Exception("查询到的集合为null");
            }
            result.setData(queryList);
        } catch (Exception e) {
            log.error("resetService getUserQuestion is error",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"查询问题集合失败:"+e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult validUserInfoExist(UserInfo userInfo) {
        MessageResult result = new MessageResult();
        /*查询用户*/
        result = userInfoService.getUserInfo(userInfo);
        /*判断返回信息*/
        if(result.isError()){
            return result;
        }else{
            List<UserInfo> list = (List<UserInfo>) result.getData();
            if(list.size() < 1){
                result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"用户信息不存在");
            }
        }
        return result;
    }

    @Override
    public MessageResult modifyPassword(UserInfo userInfo) {
        MessageResult result = new MessageResult();
        /*给密码md5加密*/
        String password = Md5Util.EncoderByMd5(userInfo.getPassWord());
        userInfo.setPassWord(password);
        result = userInfoService.updatePasswordByuserName(userInfo);
        return result;
    }

    @Override
    public MessageResult validQuestion(List<UserQuestion> list,UserQuestion userQuestion) {
        MessageResult result = new MessageResult();
        try {
            List<UserQuestion> userQuestions = userQuestionDao.queryByCondition(userQuestion);
            if(userQuestions == null){
                throw new Exception("查询出的集合为null");
            }
            if(userQuestions.size() < 1){
                throw new Exception("查询出的密保记录数小于1");
            }
            Map<Integer,String> questionMap = new HashMap<>();
            for (UserQuestion question : list) {
                questionMap.put(question.getId(),question.getQuestionAnswer());
            }

            for (UserQuestion question : userQuestions) {
                String comment = questionMap.get(question.getId());
                String commentDB = question.getQuestionComment();
                if(!comment.equals(commentDB)){
                    throw new Exception("密保有误，请重新输入");
                }
            }
        } catch (Exception e) {
            log.error("验证密保出现异常",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"验证密保出现异常:"+e.getMessage());
        }
        return result;
    }
}
