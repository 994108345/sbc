package cn.wzl.sbc.prod.dao.mapper;

import cn.wzl.sbc.prod.model.article.ArticleLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleLikeMapper {
    /**
     * 查询点赞
     * @param request
     * @return
     */
    List<ArticleLike> queryLikeByRequest(ArticleLike request);

    /**
     * 插入点赞
     * @param request
     * @return
     */
    int insertArticleLike(ArticleLike request);
}