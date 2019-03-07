package cn.wzl.sbc.prod.service.article.impl;

import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.util.CodeUtil;
import cn.wzl.sbc.common.util.MessageUtil;
import cn.wzl.sbc.common.util.OssUtil;
import cn.wzl.sbc.prod.dao.bean.brand.ArticleDao;
import cn.wzl.sbc.prod.model.Article;
import cn.wzl.sbc.prod.model.page.ArticleBean;
import cn.wzl.sbc.prod.service.article.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
    @Resource
    private CodeUtil codeUtil;

    @Override
    public PageBeanResult queryArticleByPage(ArticleBean articleBean) {
        PageBeanResult result = new PageBeanResult();
        result = articleDao.queryArticleByPage(articleBean);
        if(result.isSuccess()){
            List<Article> list = (ArrayList)result.getData();
            if(list == null || list.size()<1){
                return result;
            }
            for (Article article : list) {
                MessageResult messageResult = OssUtil.downLoadFile(article.getContent());
                if(messageResult.isError()){
                    result = MessageUtil.messageToPage(messageResult);
                    return result;
                }
                StringBuilder content = (StringBuilder)messageResult.getData();
                article.setContent(content == null ? "":content.toString());
            }
        }
        return result;
    }

    @Override
    public MessageResult updateOneArticle(Article article) {
        MessageResult result = new MessageResult();
        /*将文章内容变成流存到oss*/
        String content = article.getContent();
        byte[] bytes = content.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        String objectName = "";
        String title = article.getTitle();
        /*获取一个文件特有的code*/
        String ossFileCode = codeUtil.createCodeByRedis(RedisConstant.RedisCreateCode.CodeType.OSS_FILE_CODE);
        objectName = title + ":"+ossFileCode;
        result = OssUtil.uploadFile(inputStream,objectName);
        if(result.isError()){
            return  result;
        }
        /*将对象名存入*/
        article.setContent(objectName);
        result = articleDao.updateOneArticle(article);
        return result;
    }

    @Override
    public MessageResult insertOneArticle(Article article) {
        MessageResult result = new MessageResult();
        /*设置code*/
        String code = codeUtil.createCodeByRedis(RedisConstant.RedisCreateCode.CodeType.ARTICLE_CODE);
        article.setArticleCode(code);
        /*将文章内容变成流存到oss*/
        String content = article.getContent();
        byte[] bytes = content.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        String objectName = "";
        String title = article.getTitle();
        /*获取一个文件特有的code*/
        String ossFileCode = codeUtil.createCodeByRedis(RedisConstant.RedisCreateCode.CodeType.OSS_FILE_CODE);
        objectName = title + ":"+ossFileCode;
        result = OssUtil.uploadFile(inputStream,objectName);
        if(result.isError()){
            return  result;
        }
        /*将对象名存入*/
        article.setContent(objectName);
        result = articleDao.insertOneArticle(article);
        return result;
    }
}
