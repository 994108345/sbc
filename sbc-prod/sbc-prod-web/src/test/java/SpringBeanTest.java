import cn.wzl.sbc.SbcProdApplication;
import cn.wzl.sbc.common.util.SpringBeanUtil;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/6 11:05
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SbcProdApplication.class)
public class SpringBeanTest {

    @Test
    public void getBeanTest(){
        String json = "{brandName:'华为'}";
        Object param = JSONObject.parse(json);
        Object obj = null;
        try {
            obj = SpringBeanUtil.getBean("prodBrandServiceImpl");
            Class objClass = obj.getClass();
            Method[] methods = objClass.getMethods();
            for (Method method : methods) {
                "queryByParam".equals(method.getName());
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    Class parameterClass = parameter.getType();
                    System.out.println(parameterClass.toString());
                }
            }
            Method method = objClass.getDeclaredMethod("queryByParam", Object.class);
            Object returnMessage = method.invoke(param);
            System.out.println(returnMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
