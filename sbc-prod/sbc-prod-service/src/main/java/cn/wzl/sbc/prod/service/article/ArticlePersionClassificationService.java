package cn.wzl.sbc.prod.service.article;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.prod.model.article.ArticlePersionClassification;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/8 18:27
 * @description：
 */
public interface ArticlePersionClassificationService {

    /**
     * 查询个人分类
     * @param request
     * @return
     */
    MessageResult queryArticlePersionClassification(ArticlePersionClassification request);
}
