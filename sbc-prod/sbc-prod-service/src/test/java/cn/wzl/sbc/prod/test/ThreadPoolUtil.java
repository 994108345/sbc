package cn.wzl.sbc.prod.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 创建线程池（饿汉单例模式）
 * @author wzl
 * @date Created in 2019/4/1 11:05
 */
public class ThreadPoolUtil {

    /**
     * 线程池
     */
    public volatile static ExecutorService exec = Executors.newFixedThreadPool(20);

    private ThreadPoolUtil() {
    }

    public static ExecutorService getInstance(){
        return exec;
    }
}
