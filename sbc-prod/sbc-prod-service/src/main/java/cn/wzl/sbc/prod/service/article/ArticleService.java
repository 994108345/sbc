package cn.wzl.sbc.prod.service.article;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.model.Article;
import cn.wzl.sbc.prod.model.page.ArticleBean;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 10:36
 * @description：
 */
public interface ArticleService {

    /**
     * 查询
     * @param articleBean
     * @return
     */
    PageBeanResult queryArticleByPage(ArticleBean articleBean);

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

}