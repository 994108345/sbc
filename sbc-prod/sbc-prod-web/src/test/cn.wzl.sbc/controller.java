package cn.wzl.sbc;

import cn.wzl.sbc.common.util.SpringBeanUtil;
import cn.wzl.sbc.prod.web.controller.ProdBrandManageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 99410 on 2019/2/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SbcProdApplication.class)
public class controller {

    @Test
    public void test(){
//        Object o = SpringBeanUtil.getBean("ProdBrandManageController");
        Object o = SpringBeanUtil.getBean(ProdBrandManageController.class);
        System.out.println(o);
    }

    @Test
    public void beanFactory(){
        BeanFactory beanFactory = SpringBeanUtil.getBeanFactory();
        System.out.println(beanFactory);
    }
}
