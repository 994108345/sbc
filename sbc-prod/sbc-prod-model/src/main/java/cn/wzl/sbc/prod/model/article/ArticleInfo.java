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

}