import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * @author ：wzl
 * @date ：Created in 2019/2/23 10:44
 * @description：测试类
 */
public class StrTest {
    @Test
    public void split(){
        String[] paths = "1312123?".split("\\?");
        System.out.println(paths);
    }

    @Test
    public void dateMessage(){
        Calendar rightNow = Calendar.getInstance();
        int year = rightNow.get(Calendar.YEAR);
        int mounth = rightNow.get(Calendar.MONTH);
        System.out.println();

    }

    @Test
    public void strTest(){
        String str = "1234.jpg5.jpg";
        int a = str.indexOf(".jpg");
        System.out.println(a);
        System.out.println(str.substring(0,a+4));
    }

    @Test
    public void integerTest(){
        Integer i = 1;
        Integer j = null;
        try {
             i = 1 +  j;
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bigdecimalTest(){
        BigDecimal bd = new BigDecimal("11.9689");
        long l  = bd.setScale( 0, BigDecimal.ROUND_DOWN ).longValue();
        System.out.println();
    }

    @Test
    public void arryList(){
        ArrayTest arrayTest = new ArrayTest();
        System.out.println(arrayTest.getList());
        for (Object o : arrayTest.getList()) {
            System.out.println();
        }
    }

    class ArrayTest{
        public List list;

        public List getList() {
            return list;
        }

        public void setList(List list) {
            this.list = list;
        }
    }
}
