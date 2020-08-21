package multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable {
    private static final AtomicInteger i = new AtomicInteger(); // 线程安全的整形数变量

    @Override
    public void run() {
        for (int k = 0; k < 10000; k++) {
            i.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.submit(new AtomicIntegerTest());
        }
        es.shutdown();
        while (!es.isTerminated()){

        }
        System.out.println(i);
    }
}
