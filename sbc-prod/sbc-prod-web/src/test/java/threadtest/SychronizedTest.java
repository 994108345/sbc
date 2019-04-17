package threadtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzl
 * @date Created in 2019/4/16 18:18
 */
public class SychronizedTest {

    public static List<String> list = new ArrayList<>();

    public SychronizedTest() {
        list.add("1");
        list.add("2");list.add("3");list.add("4");list.add("5");list.add("6");
    }

    @Test
    public void testDemo(){
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());
        threadA.start();
        threadB.start();
        try {
            Thread.currentThread().sleep(1000*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class ThreadA implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (list){
                    try {
                        list.wait();
                        System.out.println("唤醒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    class ThreadB implements  Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (list){
                    try {
                        System.out.println("唤醒前");
                        list.notifyAll();
                        Thread.sleep(1000*1);
                        System.out.println("唤醒后");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
