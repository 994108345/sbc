package cn.wzl.sbc.prod.service.article;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.model.article.Article;
import cn.wzl.sbc.prod.model.article.data.ArticleAllInfo;
import cn.wzl.sbc.prod.model.article.page.ArticleBean;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 10:36
 * @description：
 */
public interface ArticleService {

    /**
     * 查询（拼文章内容）
     * @param articleBean
     * @return
     */
    PageBeanResult queryArticleByPage(ArticleBean articleBean);


    /**
     * 简单查询（不拼文章内容）
     * @param articleBean
     * @return
     */
    PageBeanResult querySimpleArticleByPage(ArticleBean articleBean);

    /**
     * 更新
     * @param article
     * @return
     */
    MessageResult updateOneArticle(Article article);

    /**
     * 插入
     * @param article
     * @return
     */
    MessageResult insertOneArticle(Article article);

    /**
     * 查询文章信息（博客首页）
     * @param articleAllInfo
     * @return
     */
    PageBeanResult queryArticleInfo(ArticleAllInfo articleAllInfo);

    /**
     * 删除文章
     * @param article
     * @return
     */
    MessageResult deleteArticleByCode(Article article);

}
