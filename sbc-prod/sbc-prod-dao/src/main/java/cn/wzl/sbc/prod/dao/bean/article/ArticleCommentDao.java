package cn.wzl.sbc.prod.dao.bean.article;

import cn.wzl.sbc.prod.model.article.ArticleComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleCommentDao {

    /**
     * 查询评论
     * @param request
     * @return
     */
    List<ArticleComment> queryCommentByRequest(ArticleComment request);

    /**
     * 插入评论
     * @param request
     * @return
     */
    int insertComment(ArticleComment request);
}