package cn.wzl.sbc.permission.web.controller;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.model.permission.UserQuestion;
import cn.wzl.sbc.permission.service.register.RegisterService;
import cn.wzl.sbc.permission.service.register.bean.UserRegisterBean;
import cn.wzl.sbc.permission.web.controller.bean.RegisterVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/24 16:19
 * @doc RegisterController
 **/
@RestController
@RequestMapping("sbc-permission/Register")
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @PostMapping("register")
    @ResponseBody
    public MessageResult register(@RequestBody RegisterVO registerVO){
        MessageResult result = new MessageResult();
        if(registerVO == null){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"请求参数不能为null");
            return result;
        }
        /*vo转成需求bean*/
        UserRegisterBean userRegisterBean = registerParamTran(registerVO);

        /*参数验证*/
        result = registerParamValid(userRegisterBean);
        /*如果参数验证有错误，立即返回*/
        if(result.isError()){
            return result;
        }

        result = registerService.register(userRegisterBean);
        return result;
    }

    /**
     * 参数验证
     * @param userRegisterBean
     * @return
     */
    public MessageResult registerParamValid(UserRegisterBean userRegisterBean){
        MessageResult result = new MessageResult();
        UserInfo userInfo = userRegisterBean.getUserInfo();
        List<UserQuestion> questionList = userRegisterBean.getQuestions();
        try{
            if(userInfo.getUserName() == null){
                throw new Exception("账号不能为null");
            }
            if(userInfo.getPassWord() == null){
                throw new Exception("密码不能为null");
            }
            for (UserQuestion userQuestion : questionList) {
                if(userQuestion.getQuestionComment() == null){
                    throw new Exception("问题内容不能为null");
                }
                if(userQuestion.getQuestionAnswer() == null){
                    throw new Exception("问题答案不能为null");
                }
                if(userQuestion.getUserName() == null){
                    throw new Exception("问题用户名不能为null");
                }
            }
        }catch (Exception e){
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    /**
     * 参数转化
     * @param registerVO
     * @return
     */
    public UserRegisterBean registerParamTran(RegisterVO registerVO){
        UserRegisterBean userRegisterBean = new UserRegisterBean();
        /*用户信息*/
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(registerVO.getUserName());
        userInfo.setPassWord(registerVO.getPassWord());

        /*问题集合*/
        List<UserQuestion> userQuestions = new ArrayList<>();
        UserQuestion userQuestion1 = new UserQuestion();
        UserQuestion userQuestion2 = new UserQuestion();
        userQuestions.add(userQuestion1);
        userQuestions.add(userQuestion2);

        userQuestion1.setUserName(userInfo.getUserName());
        userQuestion1.setQuestionComment(registerVO.getQuestion1());
        userQuestion1.setQuestionAnswer(registerVO.getAnswer1());

        userQuestion2.setUserName(userInfo.getUserName());
        userQuestion2.setQuestionComment(registerVO.getQuestion2());
        userQuestion2.setQuestionAnswer(registerVO.getAnswer2());

        userRegisterBean.setQuestions(userQuestions);
        userRegisterBean.setUserInfo(userInfo);

        return userRegisterBean;
    }
}
