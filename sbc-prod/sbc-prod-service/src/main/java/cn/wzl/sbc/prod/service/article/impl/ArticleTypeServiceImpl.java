package cn.wzl.sbc.prod.service.article.impl;

import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.util.CodeUtil;
import cn.wzl.sbc.prod.dao.bean.article.ArticleTypeDao;
import cn.wzl.sbc.prod.model.article.ArticleType;
import cn.wzl.sbc.prod.model.article.page.ArticleTypeBean;
import cn.wzl.sbc.prod.service.article.ArticleTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 10:37
 * @description：
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Resource
    private CodeUtil codeUtil;

    @Resource
    private ArticleTypeDao dao;

    @Override
    public PageBeanResult queryArticleTypeByPage(ArticleTypeBean articleBean) {
        return dao.queryArticleTypeByPage(articleBean);
    }

    @Override
    public MessageResult updateArticleTypeById(ArticleType article) {
        return dao.updateArticleTypeById(article);
    }

    @Override
    public MessageResult insertOneArticleType(ArticleType article) {
        /*获取code*/
        String code = codeUtil.createCodeByRedis(RedisConstant.RedisCreateCode.CodeType.ARTICLETYPE_CODE);
        article.setArticleTypeCode(code);
        return dao.insertOneArticleType(article);
    }
}
