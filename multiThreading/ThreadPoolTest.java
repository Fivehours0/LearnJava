package multiThreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ThreadPoolTest {
}

/**
 * 固定大小的线程池
 */
class ThreadPoolDemo {
    public static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        ExecutorService es = Executors.newFixedThreadPool(5); // 在线程池中创建了5个线程
        for (int i = 0; i < 10; i++) {
            es.submit(task);
        }
        es.shutdown();
    }
}

class ScheduleDemo {
    public static void main(String[] args) {
        ThreadPoolDemo.Task task = new ThreadPoolDemo.Task();
        ScheduledExecutorService es = Executors.newScheduledThreadPool(5); // 在线程池中创建了5个线程
        es.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
        es.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
//        es.shutdown();
    }
}