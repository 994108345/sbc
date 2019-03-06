package cn.wzl.sbc.prod.service.brand.impl;

import cn.wzl.sbc.common.constant.RedisConstant;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.common.result.ReturnResultEnum;
import cn.wzl.sbc.common.util.CodeUtil;
import cn.wzl.sbc.prod.dao.bean.brand.ProdBrandDao;
import cn.wzl.sbc.prod.model.ProdBrand;
import cn.wzl.sbc.prod.model.page.PageBrandBean;
import cn.wzl.sbc.prod.service.brand.ProdBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdBrandServiceImpl implements ProdBrandService {

    private static final Logger log = LoggerFactory.getLogger(ProdBrandServiceImpl.class);

    @Resource
    private ProdBrandDao prodBrandDao;

    @Resource
    private CodeUtil codeUtil;


    @Override
    public PageBeanResult queryByParam(PageBrandBean pageBrandBean) {
        PageBeanResult result = new PageBeanResult();
        try {
            result = prodBrandDao.queryByParam(pageBrandBean);
            List<ProdBrand> brandList = (ArrayList)result.getData();
            if(brandList.size() < 1){
                throw new Exception("查询不到对应记录");
            }
            result.setData(brandList.get(0));
        } catch (Exception e) {
            result.setMessageAndStatus(ReturnResultEnum.ERROR.getStatus(),"prodBrandService queryByParam has error ..."+ e.getMessage());
            log.error("prodBrandService queryByParam has error ...",e);
        }
        return result;
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
            /*生成品牌编码*/
            prodBrand.setBrandCode(codeUtil.createCodeByRedis(RedisConstant.RedisCreateCode.CodeType.BRAND_CODE));
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
