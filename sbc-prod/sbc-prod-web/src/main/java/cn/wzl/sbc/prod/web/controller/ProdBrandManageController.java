package cn.wzl.sbc.prod.web.controller;

import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.result.PageBeanResult;
import cn.wzl.sbc.prod.model.ProdBrand;
import cn.wzl.sbc.prod.model.page.PageBrandBean;
import cn.wzl.sbc.prod.service.brand.ProdBrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("sbc-prod/ProdBrandManage")
public class ProdBrandManageController {

    @Resource
    private ProdBrandService prodBrandService;

    @PostMapping("querybrandpage")
    @ResponseBody
    public PageBeanResult queryBrandByPage(@RequestBody PageBrandBean pageBrandBean){
        PageBeanResult result = new PageBeanResult();
        return prodBrandService.queryBrandByPage(pageBrandBean);
    }

    @PostMapping("update-brand")
    @ResponseBody
    public MessageResult updateBrand(@RequestBody ProdBrand prodBrand){
        MessageResult result = new MessageResult();
        return prodBrandService.updateBrandByCode(prodBrand);
    }

    @PostMapping("insert-brand")
    @ResponseBody
    public MessageResult insertBrand(@RequestBody ProdBrand prodBrand){
        MessageResult result = new MessageResult();
        return prodBrandService.insertBrand(prodBrand);
    }

    @PostMapping("delete-brand")
    @ResponseBody
    public MessageResult deleteBrand(@RequestBody ProdBrand prodBrand){
        MessageResult result = new MessageResult();
        return prodBrandService.deleteByParam(prodBrand);
    }
}
