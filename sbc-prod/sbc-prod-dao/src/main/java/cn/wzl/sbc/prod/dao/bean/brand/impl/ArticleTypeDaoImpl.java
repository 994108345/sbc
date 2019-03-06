package cn.wzl.sbc.prod.dao.bean.brand.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.prod.dao.bean.brand.ArticleTypeDao;
import cn.wzl.sbc.prod.dao.mapper.ArticleTypeMapper;
import cn.wzl.sbc.prod.model.ArticleType;
import cn.wzl.sbc.prod.model.page.ArticleTypeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 9:57
 * @description：
 */
@Repository
public class ArticleTypeDaoImpl implements ArticleTypeDao {

    private final static Logger log = LoggerFactory.getLogger(ArticleTypeDaoImpl.class);

    @Resource
    private ArticleTypeMapper mapper;

    @Override
    public PageBeanResult queryArticleTypeByPage(ArticleTypeBean articleBean) {
        PageBeanResult result = new PageBeanResult();
        try {
            List<ArticleType> list = mapper.queryArticleTypeByPage(articleBean);
            if(list == null){
                throw new Exception("查询出的记录为null");
            }
            if(articleBean.isPaging()){
                Integer count = mapper.queryArticleTypeCount(articleBean);
                result.setTotalRecords(count);
            }
            result.setData(list);
        } catch (Exception e) {
            log.error("ArticleTypeDao queryArticleTypeByPage has error ......",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult updateArticleTypeById(ArticleType article) {
        MessageResult result = new MessageResult();
        try {
            Integer count = mapper.updateArticleTypeById(article);
            if(count == null || count < 1){
                throw new Exception("更新记录返回参数异常:"+count);
            }
        } catch (Exception e) {
            log.error("ArticleTypeDao updateArticleTypeById has error ......",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult insertOneArticleType(ArticleType article) {
        MessageResult result = new MessageResult();
        try {
            Integer count = mapper.insertOneArticleType(article);
            if(count == null || count < 1){
                throw new Exception("插入记录返回参数异常:"+count);
            }
        } catch (Exception e) {
            log.error("ArticleTypeDao insertOneArticleType has error ......",e);
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }
}
