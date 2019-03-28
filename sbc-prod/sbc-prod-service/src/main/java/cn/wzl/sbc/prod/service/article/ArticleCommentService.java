package cn.wzl.sbc.prod.service.article;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.prod.model.article.ArticleComment;

public interface ArticleCommentService {

    /**
     * 查询文章评论列表
     * @param request
     * @return
     */
    MessageResult getArticleComments(ArticleComment request);

    /**
     * 插入一条文章评论
     * @param request
     * @return
     */
    MessageResult insertArticleComment(ArticleComment request);
}
