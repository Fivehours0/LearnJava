package multiThreading;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 为每一个线程分配一个对象
 * The Callable interface is similar to Runnable, in that both are designed for classes whose instances are potentially
 * executed by another thread. A Runnable, however, does not return a result and cannot throw a checked exception.
 */
public class ThreadLockTest implements Callable<Long> {
    private static final int numberCount = 10000000;
    private static final int threadCOUNT = 4;
    private static final ExecutorService es = Executors.newFixedThreadPool(threadCOUNT);

    private final ThreadLocal<Random> tl = new ThreadLocal<>() {
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    @Override
    public Long call() throws Exception {
        long s = System.currentTimeMillis();
        for (int i = 0; i < numberCount; i++) {
            tl.get().nextInt();
        }
        long e = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "spend time: " + (e - s));
        return e - s;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] future = new Future[threadCOUNT];
        for (int i = 0; i < threadCOUNT; i++) {
            future[i] = es.submit(new ThreadLockTest());
        }

        long totalTime = 0;
        for (int i = 0; i < threadCOUNT; i++) {
            totalTime += future[i].get();
        }
        System.out.println(totalTime);

        es.shutdown();
    }
}
