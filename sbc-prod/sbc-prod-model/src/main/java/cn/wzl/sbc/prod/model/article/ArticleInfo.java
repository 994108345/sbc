package cn.wzl.sbc.prod.model.article;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleInfo {
    private Integer id;

    private String articleInfoCode;

    private String articleCode;

    private Integer likeCount;

    private Integer commentCount;

    private Integer noLikeCount;

    private Integer clickCount;

    private Date createTime;

    private Date lastModifiedTime;

    private String remark;

    /**
     * 文章编码集合
     */
    private List<String> articleCodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleInfoCode() {
        return articleInfoCode;
    }

    public void setArticleInfoCode(String articleInfoCode) {
        this.articleInfoCode = articleInfoCode;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getArticleCodes() {
        return articleCodes;
    }

    public void setArticleCodes(List<String> articleCodes) {
        this.articleCodes = articleCodes;
    }
}