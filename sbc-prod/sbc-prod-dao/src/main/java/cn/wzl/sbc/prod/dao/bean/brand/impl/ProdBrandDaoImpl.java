package cn.wzl.sbc.prod.dao.bean.brand.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.dao.bean.brand.ProdBrandDao;
import cn.wzl.sbc.prod.dao.mapper.ProdBrandMapper;
import cn.wzl.sbc.prod.model.ProdBrand;
import cn.wzl.sbc.prod.model.page.PageBrandBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProdBrandDaoImpl implements ProdBrandDao {

    private static Logger log = LoggerFactory.getLogger(ProdBrandDaoImpl.class);

    @Resource
    private ProdBrandMapper mapper;

    @Override
    public PageBeanResult queryByParam(PageBrandBean pageBrandBean) throws Exception {
        PageBeanResult result = new PageBeanResult();
        try {
            List<ProdBrand> queryList = mapper.queryByParam(pageBrandBean);
            if(queryList == null){
                throw new Exception("查询返回结果为null");
            }
        } catch (Exception e) {
            log.error("ProdBrandDaoImpl queryByParam is error:",e);
            throw new Exception("ProdBrandDaoImpl queryByParam is error：更新错误");
        }
        return result;
    }

    @Override
    public PageBeanResult queryCountByParam(PageBrandBean pageBrandBean) throws Exception {
        PageBeanResult result = new PageBeanResult();
        try {
            int count = mapper.queryCountByParam(pageBrandBean);
            result.setTotalRecords(count);
        } catch (Exception e) {
            log.error("ProdBrandDaoImpl queryCountByParam is error:",e);
            throw new Exception("ProdBrandDaoImpl queryCountByParam is error：更新错误");
        }
        return result;
    }

    @Override
    public MessageResult deleteByParam(ProdBrand prodBrand) throws Exception {
        MessageResult result = new MessageResult();
        try {
            mapper.deleteByParam(prodBrand);
        } catch (Exception e) {
            log.error("ProdBrandDaoImpl deleteByParam is error:",e);
            throw new Exception("ProdBrandDaoImpl deleteByParam is error：更新错误");
        }
        return result;
    }

    @Override
    public MessageResult insertBrand(ProdBrand prodBrand) throws Exception {
        MessageResult result = new MessageResult();
        try {
            mapper.insertBrand(prodBrand);
        } catch (Exception e) {
            log.error("ProdBrandDaoImpl insertBrand is error:",e);
            throw new Exception("ProdBrandDaoImpl insertBrand is error：更新错误");
        }
        return result;
    }

    @Override
    public MessageResult updateBrandByCode(ProdBrand prodBrand) throws Exception {
        MessageResult result = new MessageResult();
        try {
            mapper.updateBrandByCode(prodBrand);
        } catch (Exception e) {
            log.error("ProdBrandDaoImpl updateBrandByCode is error:",e);
            throw new Exception("ProdBrandDaoImpl updateBrandByCode is error：更新错误");
        }
        return result;
    }
}
