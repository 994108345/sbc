package cn.wzl.sbc.prod.dao.bean.article.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.prod.dao.bean.article.ArticleDao;
import cn.wzl.sbc.prod.dao.mapper.ArticleMapper;
import cn.wzl.sbc.prod.model.article.Article;
import cn.wzl.sbc.prod.model.article.page.ArticleBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 9:56
 * @description：
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

    private final static Logger log = LoggerFactory.getLogger(ArticleDaoImpl.class);

    @Resource
    private ArticleMapper mapper;

    @Override
    public PageBeanResult queryArticleByPage(ArticleBean articleBean) {
        PageBeanResult result = new PageBeanResult();
        try {
            List<Article> list =  mapper.queryArticleByPage(articleBean);
            if(list == null){
                throw new Exception("查询出的集合为null");
            }
            if(articleBean.isPaging()){
                Integer count = mapper.queryArticleCount(articleBean);
                result.setTotalRecords(count);
            }
            result.setData(list);
        } catch (Exception e) {
            log.error("ArticleDao queryArticleByPage has error ......",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult updateOneArticle(Article article) {
        MessageResult result = new MessageResult();
        try {
            Integer count = mapper.updateOneArticle(article);
            if(count == null || count < 1){
                throw new Exception("更新记录返回参数异常:"+count);
            }
        } catch (Exception e) {
            log.error("ArticleDao updateOneArticle has error ......",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult insertOneArticle(Article article) {
        MessageResult result = new MessageResult();
        try {
            Integer count = mapper.insertOneArticle(article);
            if(count == null || count < 1){
                throw new Exception("插入记录返回参数异常:"+count);
            }
        } catch (Exception e) {
            log.error("ArticleDao insertOneArticle has error ......",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }
}
