package cn.wzl.sbc.prod.dao.bean.article.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.prod.dao.bean.article.ArticlePersionClassificationDao;
import cn.wzl.sbc.prod.dao.mapper.ArticlePersionClassificationMapper;
import cn.wzl.sbc.prod.model.article.ArticlePersionClassification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/8 15:31
 * @description：
 */
@Repository
public class ArticlePersionClassificationDaoImpl implements ArticlePersionClassificationDao {

    private Logger log = LoggerFactory.getLogger(ArticlePersionClassificationDaoImpl.class);

    @Resource
    private ArticlePersionClassificationMapper mapper;

    @Override
    public MessageResult insertArticlePersionClassfication(ArticlePersionClassification request) {
        MessageResult result = new MessageResult();
        try {
            int count = mapper.insertArticlePersionClassfication(request);
            if(count < 1){
                throw new Exception("插入记录数小于1");
            }
        } catch (Exception e) {
            log.error("ArticlePersionClassificationDaoImpl insertArticlePersionClassfication has error ..." + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult queryArticlePersionClassification(ArticlePersionClassification request) {
        MessageResult result = new MessageResult();
        try {
            List<ArticlePersionClassification> list = mapper.queryArticlePersionClassification(request);
            if(list == null){
                throw new Exception("查询返回结果集合为null");
            }
            result.setData(list);
        } catch (Exception e) {
            log.error("ArticlePersionClassificationDaoImpl queryArticlePersionClassification has error ..." + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult updateArticlePersionClassfication(ArticlePersionClassification request) {
        MessageResult result = new MessageResult();
        try {
            int count = mapper.updateArticlePersionClassfication(request);
            if(count < 1){
                throw new Exception("记录更新数小于1");
            }
        } catch (Exception e) {
            log.error("ArticlePersionClassificationDaoImpl updateArticlePersionClassfication has error ..." + e.getMessage(),e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }
}
