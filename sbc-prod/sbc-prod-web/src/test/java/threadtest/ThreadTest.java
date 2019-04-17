package threadtest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/** 迭代器的fast-faild失败
 * @author wzl
 * @date Created in 2019/4/16 10:17
 */
public class ThreadTest {

    public static Set<String> set = new HashSet();

    public ThreadTest() {
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
    }

    @Test
    public void setTest(){
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());
        threadA.start();
        threadB.start();
        try {
            Thread.currentThread().sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class ThreadA implements Runnable{

        @Override
        public void run() {
            try{
                while(true){
                    Set<String> set1 = new HashSet<>();
                    set1.addAll(set);
                    for (String s : set1) {
                        Thread.currentThread().sleep(1000*1);
                        System.out.println(s);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    class ThreadB implements  Runnable{

        @Override
        public void run() {
            try{
                while(true){
                    Thread.currentThread().sleep(1000*2);
                    set.remove("1");
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


}
