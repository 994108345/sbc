package cn.wzl.sbc.permission.service.register.bean;

import cn.wzl.sbc.model.permission.UserInfo;
import cn.wzl.sbc.model.permission.UserQuestion;

import java.util.List;

/**
 * @Author wzl
 * @Date 2018/12/24 15:54
 * @doc UserRegisterBean
 **/
public class UserRegisterBean {
    private UserInfo userInfo;
    private List<UserQuestion> questions;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<UserQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<UserQuestion> questions) {
        this.questions = questions;
    }
}
