package cn.wzl.sbc.prod.test;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutorService;

/**
 * @author wzl
 * @date Created in 2019/4/1 11:17
 */
@Ignore
public class ThreadPoolTest {
    @Test
    public void test1() throws InterruptedException {
        ExecutorService etc = ThreadPoolUtil.getInstance();
        for (int i = 0; i < 1000; i++) {
            etc.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (1000*0.1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread t = Thread.currentThread();
                    System.out.println("线程id"+ t.getId()+"线程name"+t.getName());
                }
            });
        }
        etc.shutdown();

        Thread.sleep(1000*3);
    }
}
