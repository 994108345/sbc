package cn.wzl.sbc.prod.service.article.impl;

import cn.wzl.sbc.common.constant.ArticleConstant;
import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.util.RedisUtil;
import cn.wzl.sbc.prod.dao.mapper.ArticleCommentMapper;
import cn.wzl.sbc.prod.model.article.ArticleComment;
import cn.wzl.sbc.prod.model.page.ArticleBean;
import cn.wzl.sbc.prod.service.article.ArticleCommentService;
import cn.wzl.sbc.prod.service.article.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/19 11:41
 * @description：
 */
@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    private static final Logger log = LoggerFactory.getLogger(ArticleCommentServiceImpl.class);

    @Resource
    private ArticleCommentMapper mapper;

    @Resource
    private ArticleService articleService;

    @Resource
    private RedisUtil redisUtil;


    @Override
    public MessageResult getArticleComments(ArticleComment request) {
        MessageResult result = new MessageResult();
        try {
            ArticleBean articleBean = new ArticleBean();
            articleBean.setIsPrivate(ArticleConstant.ArticlePrivate.NOT_PRIVATE);
            PageBeanResult pageResult = articleService.queryArticleByPage(articleBean);
            if(pageResult.isError()){
                throw new Exception("获取文章列表失败");
            }
            List<ArticleComment> list =  mapper.queryCommentByRequest(request);
            if(list == null || list.size() < 1){

            }else{

            }
        } catch (Exception e) {
            log.error("ArticleCommentServiceImpl getArticleComments has error...",e);
            result.setErrorMessage(e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult insertArticleComment(ArticleComment request) {
        MessageResult result = new MessageResult();
        try {
            request.setArticleCode(redisUtil.getTypeOfKey(RedisConstant.RedisCreateCode.CodeType.ARTICLE_COMMENT_CODE));
            mapper.insertComment(request);
        } catch (Exception e) {
            log.error("ArticleCommentServiceImpl insertArticleComment has error...",e);
            result.setErrorMessage(e.getMessage());
        }
        return result;
    }
}
