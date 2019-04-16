import data.Child;
import manage.ManageService;
import manage.impl.ChildServiceImpl;
import manage.impl.ParentServiceImpl;
import org.junit.Test;

/**
 * @author wzl
 * @date Created in 2019/4/9 17:14
 */
public class ManageTest {


    @Test
    public void test1(){
        ManageService manageService1 = new ParentServiceImpl();
        ManageService manageService2 = new ChildServiceImpl();
        Child child = new Child();
        child.setChildId("1");
        manageService1.getTest(child);

        manageService2.getTest(child);
    }

}
