package cn.wzl.sbc.model.permission;

import java.util.Date;

public class UserQuestion {
    private Integer id;

    private String userName;

    private String questionComment;

    private String quertionAnswer;

    private Date createTime;

    private Date lastModifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getQuestionComment() {
        return questionComment;
    }

    public void setQuestionComment(String questionComment) {
        this.questionComment = questionComment == null ? null : questionComment.trim();
    }

    public String getQuertionAnswer() {
        return quertionAnswer;
    }

    public void setQuertionAnswer(String quertionAnswer) {
        this.quertionAnswer = quertionAnswer == null ? null : quertionAnswer.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}