package cn.wzl.sbc.prod.dao.mapper;

import cn.wzl.sbc.prod.model.article.ArticlePersionClassification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticlePersionClassificationMapper {

    /**
     * 插入
     * @param request
     * @return
     */
    Integer insertArticlePersionClassfication(ArticlePersionClassification request);

    /**
     * 查询
     * @param request
     * @return
     */
    List<ArticlePersionClassification> queryArticlePersionClassification(ArticlePersionClassification request);

    /**
     * 更新
     * @param request
     * @return
     */
    Integer updateArticlePersionClassfication(ArticlePersionClassification request);

}