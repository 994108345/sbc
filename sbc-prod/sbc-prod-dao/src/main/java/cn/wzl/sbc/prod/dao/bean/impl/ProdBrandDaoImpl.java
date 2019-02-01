package cn.wzl.sbc.prod.dao.bean.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.prod.dao.bean.ProdBrandDao;
import cn.wzl.sbc.prod.model.ProdBrand;
import cn.wzl.sbc.prod.model.page.PageBrandBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProdBrandDaoImpl implements ProdBrandDao {

    private static Logger log = LoggerFactory.getLogger(ProdBrandDaoImpl.class);

    @Override
    public MessageResult queryByParam(PageBrandBean pageBrandBean) {
        MessageResult result = new MessageResult();

        return result;
    }

    @Override
    public MessageResult queryCountByParam(PageBrandBean pageBrandBean) {
        MessageResult result = new MessageResult();
        return result;
    }

    @Override
    public MessageResult deleteByParam(ProdBrand prodBrand) {
        MessageResult result = new MessageResult();
        return result;
    }

    @Override
    public MessageResult insertBrand(ProdBrand prodBrand) {
        MessageResult result = new MessageResult();
        return result;
    }

    @Override
    public MessageResult updateBrandByCode(ProdBrand prodBrand) {
        MessageResult result = new MessageResult();
        return result;
    }
}
