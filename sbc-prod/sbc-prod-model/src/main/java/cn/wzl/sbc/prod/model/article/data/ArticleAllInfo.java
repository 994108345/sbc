package cn.wzl.sbc.prod.model.article.data;

import cn.wzl.sbc.prod.model.article.ArticleInfo;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author wzl
 * @date Created in 2019/3/26 16:36
 */
@Data
public class ArticleAllInfo {
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
}
