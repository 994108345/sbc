package cn.wzl.sbc.model.chatboard.page;

import cn.wzl.sbc.model.page.PageBean;

import java.util.Date;

/**
 * @Author wzl
 * @Date 2018/12/20 13:15
 * @doc CommentPageBean
 **/
public class CommentPageBean extends PageBean {
    private Integer id;

    private String userId;

    private String userName;

    private String comment;

    private Date createTime;

    private Date lastModifyDatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyDatetime() {
        return lastModifyDatetime;
    }

    public void setLastModifyDatetime(Date lastModifyDatetime) {
        this.lastModifyDatetime = lastModifyDatetime;
    }
}
