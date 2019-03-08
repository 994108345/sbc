package cn.wzl.sbc.prod.service.article.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.prod.dao.bean.brand.ArticlePersionClassificationDao;
import cn.wzl.sbc.prod.model.ArticlePersionClassification;
import cn.wzl.sbc.prod.service.article.ArticlePersionClassificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/8 18:27
 * @description：
 */
@Service
public class ArticlePersionClassificationServiceImpl implements ArticlePersionClassificationService {

    @Resource
    private ArticlePersionClassificationDao pcDao;

    @Override
    public MessageResult queryArticlePersionClassification(ArticlePersionClassification request) {
        request.setUserName(request.getUsrInfoUserName());
        return pcDao.queryArticlePersionClassification(request);
    }
}
