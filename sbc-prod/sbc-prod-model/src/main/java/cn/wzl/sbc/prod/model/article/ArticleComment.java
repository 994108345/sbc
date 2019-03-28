package cn.wzl.sbc.prod.model.article;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleComment {
    private Integer id;

    private String articleCommentCode;

    private String userCode;

    private String articleCode;

    private String parentCommentCode;

    private Date createTime;

    private Date lastModifiedTime;

    private String remark;

}