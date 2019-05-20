import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

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

    @Test
    public void dubboTest(){
        double b = 323.34;
        double a = 4.85;
        double c = a - b;
        String str = String.valueOf(b);
        System.out.println(b);
    }

    @Test
    public void  voidaddTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println(calendar.getTime());
    }

    @Test
    public void sum(){
        int a = 10;
        int b = 3;
        Double c = new Double(100*b)/new Double(a);
        System.out.println(c);
    }

    @Test
    public void multi(){
        BigDecimal a = new BigDecimal("3");
        BigDecimal b = new BigDecimal("7");
        BigDecimal c = new BigDecimal("12");
        BigDecimal d = (a.divide(b,2,RoundingMode.FLOOR).multiply(new BigDecimal("100")));
        BigDecimal e = a.divide(b,3,RoundingMode.FLOOR);
        System.out.println();
    }

    @Test
    public void DemoTest1(){
        int a= 1;
        int b = 18;
        if(b >= 1){
            System.out.println("1");
        }else{
            System.out.println("2");
        }
    }

    @Test
    public void DemoTest(){
        String uuId = UUID.randomUUID().toString();
        System.out.println(uuId);
    }

    @Test
    public void containTest(){
        String str = "132654\"\"987";
        System.out.println(str);
    }

    @Test
    public void test(){
        String a = null + "";
        System.out.println(a);
    }

    @Test
    public void str4Test(){
        String str = "\\n123\\tdfdf\\rgdgasdf\\ndfgfg";
        System.out.println("转义前："+ StringEscapeUtils.unescapeJava(str));
        String str1 =str.replaceAll("\\\\", "/");
        System.out.println(str1);
        String str2= StringEscapeUtils.unescapeJava(str1);
        System.out.println("转义后："+ str2);
    }

    @Test
    public void str5Test(){
        BigDecimal big = new BigDecimal("0.1").multiply(new BigDecimal("1"));
        System.out.println(big);
    }

    @Test
    public void millionTest(){
        System.out.println(Calendar.getInstance().getTimeInMillis() / 1000);
    }

    @Test
    public void uuidTest(){
        String str = UUID.randomUUID().toString();
        System.out.println(str);

    }

    @Test
    public void listTest(){
        ListA listA = new ListA();
        List<String> strList = null;
        try {
            strList = listA.getStrList();
            for (String s : strList) {
                System.out.println(1);
            }
            System.out.println(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    class ListA{
        List<String> strList;

        public List<String> getStrList() {
            return strList;
        }

        public void setStrList(List<String> strList) {
            this.strList = strList;
        }
    }
}
