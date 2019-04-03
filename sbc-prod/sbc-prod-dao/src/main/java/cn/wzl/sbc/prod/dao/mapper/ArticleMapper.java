package cn.wzl.sbc.prod.dao.mapper;

import cn.wzl.sbc.prod.model.article.Article;
import cn.wzl.sbc.prod.model.article.data.ArticleAllInfo;
import cn.wzl.sbc.prod.model.article.page.ArticleBean;
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

    /**
     * 查询文章+文章其他信息
     * @return
     */
    List<ArticleAllInfo> queryArticleInfo(ArticleAllInfo articleAllInfo);

    /**
     * 查询文章+文章其他信息记录数
     * @return
     */
    int queryArticleInfoCount(ArticleAllInfo articleAllInfo);

    /**
     * 根据articleCode删除文章
     * @param article
     * @return
     */
    int deleteArticleByCode(Article article);

    /**
     * 查询文章的具体内容
     * @param articleAllInfo
     * @return
     */
    List<ArticleAllInfo> queryArticleAllInfoByCode(ArticleAllInfo articleAllInfo);

}