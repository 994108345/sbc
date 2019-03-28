package cn.wzl.sbc.prod.dao.bean.article;

import cn.wzl.sbc.prod.model.article.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleInfoDao {

    /**
     * 查询
     * @param request
     * @return
     */
    List<ArticleInfo> queryArticleInfoByRequest(ArticleInfo request);

    /**
     * 插入
     * @param request
     * @return
     */
    int insertArticleInfo(ArticleInfo request);

    /**
     * 更新
     * @param request
     * @return
     */
    int updateArticleInfo(ArticleInfo request);
}