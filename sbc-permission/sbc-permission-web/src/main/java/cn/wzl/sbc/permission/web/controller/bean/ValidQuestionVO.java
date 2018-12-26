package cn.wzl.sbc.permission.web.controller.bean;

import cn.wzl.sbc.model.permission.UserQuestion;

import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/26 19:57
 * @doc ValidQuestionVO
 **/
public class ValidQuestionVO {

    /**
     * questino集合
     */
    private List<UserQuestion> userQuestions;

    public List<UserQuestion> getUserQuestions() {
        return userQuestions;
    }

    public void setUserQuestions(List<UserQuestion> userQuestions) {
        this.userQuestions = userQuestions;
    }
}
