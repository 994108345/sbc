package cn.wzl.sbc.prod.dao.bean;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.prod.model.ProdBrand;
import cn.wzl.sbc.prod.model.page.PageBrandBean;

public interface ProdBrandDao {
    /**
     * 查询分页数据
     * @param pageBrandBean
     * @return
     */
    MessageResult queryByParam(PageBrandBean pageBrandBean);

    /**
     * 查询记录数
     * @param pageBrandBean
     * @return
     */
    MessageResult queryCountByParam(PageBrandBean pageBrandBean);

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
}
