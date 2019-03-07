import cn.wzl.sbc.SbcProdApplication;
import cn.wzl.sbc.common.result.MessageResult;
import cn.wzl.sbc.common.util.OssUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/7 14:25
 * @description：oss测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= SbcProdApplication.class)
public class OssTest {

    @Test
    public void uploadFileTest(){
        byte[] bytes = {1,2,4,8,9,5,4,7,25,6,98,78,14,8};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        MessageResult result = OssUtil.uploadFile(inputStream,"测试1");
        System.out.println(result);
    }

}
