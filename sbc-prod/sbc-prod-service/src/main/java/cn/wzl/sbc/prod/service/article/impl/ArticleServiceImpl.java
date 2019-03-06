package cn.wzl.sbc.prod.service.article.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.dao.bean.brand.ArticleDao;
import cn.wzl.sbc.prod.model.Article;
import cn.wzl.sbc.prod.model.page.ArticleBean;
import cn.wzl.sbc.prod.service.article.ArticleService;
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
public class ArticleServiceImpl implements ArticleService {

    private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Resource
    private ArticleDao articleDao;

    @Override
    public PageBeanResult queryArticleByPage(ArticleBean articleBean) {
        PageBeanResult result = new PageBeanResult();
        result = articleDao.queryArticleByPage(articleBean);
        return result;
    }

    @Override
    public MessageResult updateOneArticle(Article article) {
        MessageResult result = new MessageResult();
        result = articleDao.updateOneArticle(article);
        return result;
    }

    @Override
    public MessageResult insertOneArticle(Article article) {
        MessageResult result = new MessageResult();
        result = articleDao.insertOneArticle(article);
        return result;
    }
}
