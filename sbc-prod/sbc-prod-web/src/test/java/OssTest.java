import cn.wzl.sbc.SbcProdApplication;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.util.ArrayUtil;
import cn.wzl.sbc.common.util.OssUtil;
import cn.wzl.sbc.common.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/7 14:25
 * @description：oss测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SbcProdApplication.class)
public class OssTest {

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void uploadFileTest(){
        byte[] bytes = {1,2,4,8,9,5,4,7,25,6,98,78,14,8};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        MessageResult result = OssUtil.uploadFile(inputStream,"测试1");
        System.out.println(result);
    }

    @Test
    public void redisTest(){
        try {
            String a = (String)redisUtil.getByKey("123123123213");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void arrTest(){
        String[] arr1 = {"1","3","4"};
        String[] arr2 = {"1","2","3"};
        List<String> list = new ArrayList<>();
        list.add("5");list.add("2");list.add("6");
        String[] arr3 = new String[0];
        try {
            arr3 = ArrayUtil.arrAddList(arr1,list,String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(arr3);

    }

}
