package cn.wzl.sbc.prod.model.article;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleLike {
    private Integer id;

    private String articleLikeCode;

    private String userCode;

    private String articleCode;

    private Date createTime;

    private Date lastModifiedTime;

    private String remark;

}