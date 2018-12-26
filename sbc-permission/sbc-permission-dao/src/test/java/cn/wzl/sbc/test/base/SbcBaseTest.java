package cn.wzl.sbc.test.base;


import cn.wzl.sbc.PermissionApplication;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 基本测试类，集合了spring-boot的测试类
 *
 * @author 程亮
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes= PermissionApplication.class)
@Ignore
public class SbcBaseTest {

	
}