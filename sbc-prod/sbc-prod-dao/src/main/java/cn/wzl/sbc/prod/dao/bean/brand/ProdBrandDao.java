package cn.wzl.sbc.prod.dao.bean.brand;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.model.ProdBrand;
import cn.wzl.sbc.prod.model.page.PageBrandBean;

public interface ProdBrandDao {
    /**
     * 查询分页数据
     * @param pageBrandBean
     * @return
     */
    PageBeanResult queryByParam(PageBrandBean pageBrandBean) throws Exception;

    /**
     * 查询记录数
     * @param pageBrandBean
     * @return
     */
    PageBeanResult queryCountByParam(PageBrandBean pageBrandBean) throws Exception;

    /**
     * 删除品牌
     * @param prodBrand
     * @return
     */
    MessageResult deleteByParam(ProdBrand prodBrand) throws Exception;

    /**
     * 插入品牌
     * @param prodBrand
     * @return
     */
    MessageResult insertBrand(ProdBrand prodBrand) throws Exception;

    /**
     * 根据编码更新品牌
     * @param prodBrand
     * @return
     */
    MessageResult updateBrandByCode(ProdBrand prodBrand) throws Exception;
}
