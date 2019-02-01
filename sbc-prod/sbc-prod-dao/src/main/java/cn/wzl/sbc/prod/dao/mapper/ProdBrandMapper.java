package cn.wzl.sbc.prod.dao.mapper;


import cn.wzl.sbc.prod.model.ProdBrand;
import cn.wzl.sbc.prod.model.page.PageBrandBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProdBrandMapper {

    /**
     * 查询分页数据
     * @param pageBrandBean
     * @return
     */
    List<ProdBrand> queryByParam(PageBrandBean pageBrandBean);

    /**
     * 查询记录数
     * @param pageBrandBean
     * @return
     */
    int queryCountByParam(PageBrandBean pageBrandBean);

    /**
     * 删除品牌
     * @param prodBrand
     * @return
     */
    int deleteByParam(ProdBrand prodBrand);

    /**
     * 插入品牌
     * @param prodBrand
     * @return
     */
    int insertBrand(ProdBrand prodBrand);

    /**
     * 根据编码更新品牌
     * @param prodBrand
     * @return
     */
    int updateBrandByCode(ProdBrand prodBrand);


}