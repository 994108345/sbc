package cn.wzl.sbc.prod.dao.mapper;

import cn.wzl.sbc.prod.model.Article;
import cn.wzl.sbc.prod.model.page.ArticleBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    /**
     * 查询
     * @param articleBean
     * @return
     */
    List<Article> queryArticleByPage(ArticleBean articleBean);

    /**
     * 查询记录数
     * @param articleBean
     * @return
     */
    int queryArticleCount(ArticleBean articleBean);

    /**
     * 更新
     * @param article
     * @return
     */
    int updateOneArticle(Article article);

    /**
     * 插入
     * @param article
     * @return
     */
    int insertOneArticle(Article article);

}