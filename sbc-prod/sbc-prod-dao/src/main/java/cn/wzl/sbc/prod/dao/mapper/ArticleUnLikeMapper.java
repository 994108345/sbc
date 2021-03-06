package cn.wzl.sbc.prod.dao.mapper;

import cn.wzl.sbc.prod.model.article.ArticleUnLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleUnLikeMapper {
    /**
     * 查询反赞
     * @param request
     * @return
     */
    List<ArticleUnLike> queryUnLikeByRequest(ArticleUnLike request);

    /**
     * 插入反赞
     * @param request
     * @return
     */
    int insertUnLike(ArticleUnLike request);
}