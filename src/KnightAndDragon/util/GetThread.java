package KnightAndDragon.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GetThread {

    private static ThreadPoolExecutor threadPoolExecutor;

    static {
          threadPoolExecutor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
    }
    public static  ThreadPoolExecutor getThreadInstance(){

        return threadPoolExecutor;
    }

    public static String getAvtiveNum(){
        return "线程池使用数量:"+threadPoolExecutor.getActiveCount();
    }
}
