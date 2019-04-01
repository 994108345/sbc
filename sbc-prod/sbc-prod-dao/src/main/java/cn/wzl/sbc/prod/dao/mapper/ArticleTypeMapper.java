package cn.wzl.sbc.prod.dao.mapper;

import cn.wzl.sbc.prod.model.article.ArticleType;
import cn.wzl.sbc.prod.model.article.page.ArticleTypeBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleTypeMapper {

    /**
     * 查询
     * @param articleBean
     * @return
     */
    List<ArticleType> queryArticleTypeByPage(ArticleTypeBean articleBean);

    /**
     * 更新
     * @param article
     * @return
     */
    Integer updateArticleTypeById(ArticleType article);

    /**
     * 插入
     * @param article
     * @return
     */
    Integer insertOneArticleType(ArticleType article);

    /**
     * 查询记录数
     * @param articleBean
     * @return
     */
    Integer queryArticleTypeCount(ArticleTypeBean articleBean);
}