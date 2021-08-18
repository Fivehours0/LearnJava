package multiThreading;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    private final int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    public void tryRead() {
        try {
//            Thread.sleep(1000);
            readLock.lock();
//            System.out.println("获取了读锁");
            System.out.println(Arrays.toString(arr));
        } finally {
            readLock.unlock();
        }
    }

    public void tryWrite() {
        try {
            writeLock.lock();
            System.out.println("获取了写锁");
//            Thread.sleep(3000);
            for (int i = 0; i < 1000000000; i++) {

            }
            arr[0] = 2;
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Runnable write = new Runnable() {
            @Override
            public void run() {
                test.tryWrite();
            }
        };

        Runnable read = new Runnable() {
            @Override
            public void run() {
                test.tryRead();
            }
        };
        // 这两个不是同一个线程。所以读锁和写锁是会相互阻塞的
        pool.execute(write);
        pool.execute(read);
    }
}
