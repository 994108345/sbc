package cn.wzl.sbc.prod.model.article.data;

import cn.wzl.sbc.model.page.PageBean;
import cn.wzl.sbc.prod.model.article.ArticleInfo;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author wzl
 * @date Created in 2019/3/26 16:36
 */
@Data
public class ArticleAllInfo extends PageBean {
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
     * 审核状态（0未审核，2审核失败，1审核成功）
     */
    private String auditStatus;

    /**
     * 是否原创：0转载，1原创，2翻译
     */
    private  String isOriginal;

    /**
     * 文章其他信息
     */
    private ArticleInfo articleInfo;

    /**
     * 文章上传路由
     */
    private String ossUrl;

    /**
     * 缩略内容
     */
    private String shortComment;

    private String articleInfoCode;

    private Integer likeCount;

    private Integer commentCount;

    private Integer noLikeCount;

    private Integer clickCount;

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
        this.articleCode = articleCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        this.createUser = createUser;
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
        this.lastModifiedUser = lastModifiedUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getArticlePersonalClassification() {
        return articlePersonalClassification;
    }

    public void setArticlePersonalClassification(String articlePersonalClassification) {
        this.articlePersonalClassification = articlePersonalClassification;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getIsOriginal() {
        return isOriginal;
    }

    public void setIsOriginal(String isOriginal) {
        this.isOriginal = isOriginal;
    }

    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }

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

    public String getArticleInfoCode() {
        return articleInfoCode;
    }

    public void setArticleInfoCode(String articleInfoCode) {
        this.articleInfoCode = articleInfoCode;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getNoLikeCount() {
        return noLikeCount;
    }

    public void setNoLikeCount(Integer noLikeCount) {
        this.noLikeCount = noLikeCount;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }
}
