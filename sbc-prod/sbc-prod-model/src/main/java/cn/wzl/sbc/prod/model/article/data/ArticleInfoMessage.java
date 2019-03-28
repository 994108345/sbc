package cn.wzl.sbc.prod.model.article.data;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/19 11:52
 * @description：
 */
@Data
public class ArticleInfoMessage {

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

    private String articleInfoCode;

    private Integer likeCount;

    private Integer commentCount;

    private Integer noLikeCount;

}
