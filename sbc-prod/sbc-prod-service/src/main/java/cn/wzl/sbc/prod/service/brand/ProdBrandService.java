package cn.wzl.sbc.prod.service.brand;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.model.prod.ProdBrand;
import cn.wzl.sbc.prod.model.prod.page.PageBrandBean;

public interface ProdBrandService {
    /**
     * 查询分页数据
     * @param pageBrandBean
     * @return
     */
    PageBeanResult queryByParam(PageBrandBean pageBrandBean);

    /**
     * 查询记录数
     * @param pageBrandBean
     * @return
     */
    PageBeanResult queryCountByParam(PageBrandBean pageBrandBean);

    /**
     * 删除品牌
     * @param prodBrand
     * @return
     */
    MessageResult deleteByParam(ProdBrand prodBrand);

    /**
     * 插入品牌
     * @param prodBrand
     * @return
     */
    MessageResult insertBrand(ProdBrand prodBrand);

    /**
     * 根据编码更新品牌
     * @param prodBrand
     * @return
     */
    MessageResult updateBrandByCode(ProdBrand prodBrand);

    /**
     * 查询分页记录
     * @param pageBrandBean
     * @return
     */
    PageBeanResult queryBrandByPage(PageBrandBean pageBrandBean);
}
