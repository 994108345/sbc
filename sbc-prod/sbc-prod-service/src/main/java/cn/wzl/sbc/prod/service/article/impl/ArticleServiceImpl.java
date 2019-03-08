package cn.wzl.sbc.prod.service.article.impl;

import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.util.ArrayUtil;
import cn.wzl.sbc.common.util.CodeUtil;
import cn.wzl.sbc.common.util.MessageUtil;
import cn.wzl.sbc.common.util.OssUtil;
import cn.wzl.sbc.prod.dao.bean.brand.ArticleDao;
import cn.wzl.sbc.prod.dao.bean.brand.ArticlePersionClassificationDao;
import cn.wzl.sbc.prod.model.Article;
import cn.wzl.sbc.prod.model.ArticlePersionClassification;
import cn.wzl.sbc.prod.model.page.ArticleBean;
import cn.wzl.sbc.prod.service.article.ArticleService;
import org.apache.logging.log4j.core.util.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

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
    @Resource
    private ArticlePersionClassificationDao articlePersionClassificationDao;

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
    public PageBeanResult querySimpleArticleByPage(ArticleBean articleBean) {
        return articleDao.queryArticleByPage(articleBean);
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
        String userName = article.getUsrInfoUserName();
        /*设置code*/
        String code = codeUtil.createCodeByRedis(RedisConstant.RedisCreateCode.CodeType.ARTICLE_CODE);
        article.setArticleCode(code);
        /**将文章内容变成流存到oss*/
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
        /**将判断个人分类是否存在*/
        String persionClass = article.getArticlePersonalClassification();
        ArticlePersionClassification persionClassification = new ArticlePersionClassification();
        persionClassification.setUserName(userName);
        result = articlePersionClassificationDao.queryArticlePersionClassification(persionClassification);
        if(result.isError()){
            return result;
        }
        List<ArticlePersionClassification> list =(ArrayList) result.getData();
        /*不存在就插入，存在就更新*/
        if(list.size() == 0){
            persionClassification.setCreateUser(userName);
            persionClassification.setLastModifiedUser(userName);
            persionClassification.setPersionClassification(article.getArticlePersonalClassification());
            result = articlePersionClassificationDao.insertArticlePersionClassfication(persionClassification);
            if(result.isError()){
                return result;
            }
        }else{
            ArticlePersionClassification articlePC = list.get(0);
            /*自我分类判断，若自我分类没有新增，即无需更新操作，有新增，即更新*/
            String str = persionClassContrast(article.getArticlePersonalClassification(),articlePC.getPersionClassification());
            if(str != null){
                articlePC.setPersionClassification(str);
                articlePC.setLastModifiedUser(userName);
                articlePC.setCreateUser(userName);
                result = articlePersionClassificationDao.updateArticlePersionClassfication(articlePC);
                if(result.isError()){
                    return result;
                }
            }
        }
        String[] classes = persionClass.split(",");
        /*将对象名存入*/
        article.setContent(objectName);
        result = articleDao.insertOneArticle(article);
        return result;
    }

    /**
     * 个人分类对比
     * @param newPC
     * @param oldPC
     * @return 返回null说明个人分类没有变化不需要新
     */
    public String persionClassContrast(String newPC ,String oldPC){
        String[] oldPCs = oldPC.split(",");
        String[] newPCs = newPC.split(",");
        /*新类型和旧类型对比，找出不同的部分*/
        List<String> beyond = ArrayUtil.arrContrast(newPCs,oldPCs);
        /*将新增的类别插入到旧的类别中，并返回处理后的旧类别*/
        int size = beyond.size();
        String[] oldNew = null;
        if(size < 1){
            /*返回null代表没有新增的类型，不需要更新操作*/
            return null;
        }else{
            oldNew = ArrayUtil.arrAddList(oldPCs,beyond,String.class);
        }
        /*将结果数组拼成字符串*/
        String result = ArrayUtil.arrToStr(oldNew,",");
        return result;
    }
}
