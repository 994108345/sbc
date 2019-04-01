package cn.wzl.sbc.prod.model.article.page;

import cn.wzl.sbc.model.page.PageBean;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 9:52
 * @description：文章类型分页实体类
 */
public class ArticleTypeBean extends PageBean {

    private Integer id;

    private String articleTypeCode;

    private String articleName;

    private String status;

    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    private String createUser;

    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date lastModifiedTime;

    private String lastModifiedUser;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleTypeCode() {
        return articleTypeCode;
    }

    public void setArticleTypeCode(String articleTypeCode) {
        this.articleTypeCode = articleTypeCode == null ? null : articleTypeCode.trim();
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
