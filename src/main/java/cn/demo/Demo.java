package cn.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue(1000);
        ThreadPoolExecutor po = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.MILLISECONDS, bq);
        KeyFrame kf = new KeyFrame();
        kf.showPanel();
        for (int i = 0; i < 1000; i++) {
            po.submit(kf);
        }
    }
}
