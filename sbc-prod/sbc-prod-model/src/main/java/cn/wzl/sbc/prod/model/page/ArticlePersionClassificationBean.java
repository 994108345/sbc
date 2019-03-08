package cn.wzl.sbc.prod.model.page;

import cn.wzl.sbc.model.page.PageBean;

import java.util.Date;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/8 15:28
 * @description：
 */
public class ArticlePersionClassificationBean extends PageBean {
    private Integer id;

    private String userName;

    private String persionClassification;

    private Date createTime;

    private String createUser;

    private Date lastModifiedTime;

    private String lastModifiedUser;

    private String remark;

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

    public String getPersionClassification() {
        return persionClassification;
    }

    public void setPersionClassification(String persionClassification) {
        this.persionClassification = persionClassification == null ? null : persionClassification.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser == null ? null : lastModifiedUser.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
