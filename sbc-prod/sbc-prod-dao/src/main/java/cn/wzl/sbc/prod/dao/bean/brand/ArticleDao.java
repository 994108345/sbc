package cn.wzl.sbc.prod.dao.bean.brand;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.model.Article;
import cn.wzl.sbc.prod.model.page.ArticleBean;

import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 9:56
 * @description：
 */
public interface ArticleDao {
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
