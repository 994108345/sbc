import cn.wzl.sbc.model.permission.UserInfo;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class JsonTest {
    @Test
    public void testOne(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("123");
        userInfo.setPassWord("123");
        String str = JSON.toJSONString(userInfo);
        System.out.println(str);
    }
}
