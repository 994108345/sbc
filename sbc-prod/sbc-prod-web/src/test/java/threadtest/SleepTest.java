package threadtest;

import org.junit.Test;

/**
 * @author wzl
 * @date Created in 2019/4/16 21:21
 */
public class SleepTest {

    @Test
    public void sleepTest(){
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
                try {
                    System.out.println("线程1-1");
                    Thread.sleep(1000*3);
                    System.out.println("线程1-2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class ThreadB implements  Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("线程2-1");
                    Thread.sleep(1000*1);
                    System.out.println("线程2-2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
