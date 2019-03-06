package cn.wzl.sbc.prod.dao.bean.brand;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.model.ArticleType;
import cn.wzl.sbc.prod.model.page.ArticleTypeBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 9:57
 * @description：
 */

public interface ArticleTypeDao {
    /**
     * 查询
     * @param articleBean
     * @return
     */
    PageBeanResult queryArticleTypeByPage(ArticleTypeBean articleBean);

    /**
     * 更新
     * @param article
     * @return
     */
    MessageResult updateArticleTypeById(ArticleType article);

    /**
     * 插入
     * @param article
     * @return
     */
    MessageResult insertOneArticleType(ArticleType article);
}
