package cn.wzl.sbc.prod.model.article.page;

import cn.wzl.sbc.model.page.PageBean;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 9:52
 * @description：文章分页实体类
 */
@Data
public class ArticleBean  extends PageBean {
    private Integer id;

    private String articleCode;

    private String userId;

    private String articleType;

    private String author;

    private String title;

    private String content;

    private String tags;

    private String status;

    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    private String createUser;

    @JSONField(format="yyyy-MM-dd hh:mm:ss")
    private Date lastModifiedTime;

    private String lastModifiedUser;

    private String remark;

    private String isPrivate;

    /**
     * 个人分类
     */
    private String articlePersonalClassification;

    /**
     * 个人分类集合
     */
    private List<String> articlePersonalClassificationList;

    /**
     * 个人分类数组
     */
    private String[] articlePersonalClassficationArr;

    /**
     * 审核状态（0未审核，2审核失败，1审核成功）
     */
    private String auditStatus;

    /**
     * 是否原创：0转载，1原创，2翻译
     */
    private  String isOriginal;

    /**
     * 文章上传路由
     */
    private String ossUrl;

    /**
     * 缩略内容
     */
    private String shortComment;

    public String getOssUrl() {
        return ossUrl;
    }

    public void setOssUrl(String ossUrl) {
        this.ossUrl = ossUrl;
    }

    public String getShortComment() {
        return shortComment;
    }

    public void setShortComment(String shortComment) {
        this.shortComment = shortComment;
    }

    public String[] getArticlePersonalClassficationArr() {
        return articlePersonalClassficationArr;
    }

    public void setArticlePersonalClassficationArr(String[] articlePersonalClassficationArr) {
        this.articlePersonalClassficationArr = articlePersonalClassficationArr;
    }

    public List<String> getArticlePersonalClassificationList() {
        return articlePersonalClassificationList;
    }

    public void setArticlePersonalClassificationList(List<String> articlePersonalClassificationList) {
        this.articlePersonalClassificationList = articlePersonalClassificationList;
    }

    public String getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(String isOriginal) {
        this.isOriginal = isOriginal;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getArticlePersonalClassification() {
        return articlePersonalClassification;
    }

    public void setArticlePersonalClassification(String articlePersonalClassification) {
        this.articlePersonalClassification = articlePersonalClassification;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode == null ? null : articleCode.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType == null ? null : articleType.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
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
