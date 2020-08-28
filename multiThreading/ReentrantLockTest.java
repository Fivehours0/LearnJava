package multiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}

/**
 * 重入锁的好搭档: Condition条件
 */
class ConditionTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await(); // 进入等待，并且释放重入锁
            System.out.println("continue run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest test = new ConditionTest();
        Thread t1 = new Thread(test);
        t1.start();
        Thread.sleep(2000);
        lock.lock(); // 与wait和notify一样，执行前都需要获得锁
        condition.signal();
        lock.unlock(); // 需要释放锁，如果不释放，t1线程依旧无法继续执行
    }
}

class ReadWriteTest implements Runnable {
    public static ReentrantReadWriteLock RWLock = new ReentrantReadWriteLock();
    private static final Lock readLock = RWLock.readLock(); // 我觉得可能是通过信号量来实现的
    private static final Lock writeLock = RWLock.writeLock();
    private static final ReentrantLock lock = new ReentrantLock();

    private void handleWrite (Lock lock) {
        try {
            lock.lock();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
//        handleWrite(readLock); // 读写锁
        handleWrite(lock); // 重入锁
    }

    public static void main(String[] args) {
        ReadWriteTest test = new ReadWriteTest();
        for (int i = 0; i < 20; i++) {
            new Thread(test).start();
        }
    }
}