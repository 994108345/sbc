package cn.wzl.sbc.prod.dao.bean.brand;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.prod.model.ArticlePersionClassification;

import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/8 15:31
 * @description：
 */
public interface ArticlePersionClassificationDao {

    /**
     * 插入
     * @param request
     * @return
     */
    MessageResult insertArticlePersionClassfication(ArticlePersionClassification request);

    /**
     * 查询
     * @param request
     * @return
     */
    MessageResult queryArticlePersionClassification(ArticlePersionClassification request);

    /**
     * 更新
     * @param request
     * @return
     */
    MessageResult updateArticlePersionClassfication(ArticlePersionClassification request);

}
