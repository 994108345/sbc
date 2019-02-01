package cn.wzl.sbc.prod.service.brand.impl;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.prod.dao.bean.brand.ProdBrandDao;
import cn.wzl.sbc.prod.model.ProdBrand;
import cn.wzl.sbc.prod.model.page.PageBrandBean;
import cn.wzl.sbc.prod.service.brand.ProdBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProdBrandServiceImpl implements ProdBrandService {

    private static final Logger log = LoggerFactory.getLogger(ProdBrandServiceImpl.class);

    @Resource
    private ProdBrandDao prodBrandDao;

    @Override
    public PageBeanResult queryByParam(PageBrandBean pageBrandBean) {
        return null;
    }

    @Override
    public PageBeanResult queryCountByParam(PageBrandBean pageBrandBean) {
        return null;
    }

    @Override
    public MessageResult deleteByParam(ProdBrand prodBrand) {
        MessageResult result = new MessageResult();
        try {
            prodBrandDao.deleteByParam(prodBrand);
        } catch (Exception e) {
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult insertBrand(ProdBrand prodBrand) {
        MessageResult result = new MessageResult();
        try {
            prodBrandDao.insertBrand(prodBrand);
        } catch (Exception e) {
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @Override
    public MessageResult updateBrandByCode(ProdBrand prodBrand) {
        MessageResult result = new MessageResult();
        try {
            prodBrandDao.updateBrandByCode(prodBrand);
        } catch (Exception e) {
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }

    @Override
    public PageBeanResult queryBrandByPage(PageBrandBean pageBrandBean) {
        PageBeanResult result = new PageBeanResult();
        try {
            /*查询分页记录*/
            PageBeanResult queryResult = prodBrandDao.queryByParam(pageBrandBean);
            if(queryResult.isError()){
                throw new Exception(queryResult.getMessage());
            }
            /*查询记录总数*/
            PageBeanResult countResult = prodBrandDao.queryCountByParam(pageBrandBean);
            result.setTotalRecords(countResult.getTotalRecords());
            result.setData(queryResult.getData());
        } catch (Exception e) {
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),e.getMessage());
        }
        return result;
    }
}
