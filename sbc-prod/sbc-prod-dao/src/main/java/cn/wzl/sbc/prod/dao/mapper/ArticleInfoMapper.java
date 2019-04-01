package cn.wzl.sbc.prod.dao.mapper;

import cn.wzl.sbc.prod.model.article.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleInfoMapper {

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

    /**
     * 根据文章code集合查询文章信息
     * @return
     */
    List<ArticleInfo> queryArticleInfoByCodes(ArticleInfo articleInfo);

    /**
     * 删除文章具体信息
     * @param articleInfo
     * @return
     */
    int deleteArticleInfoByCode(ArticleInfo articleInfo);
}