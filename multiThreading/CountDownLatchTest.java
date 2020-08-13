package multiThreading;

import java.util.concurrent.CountDownLatch;

/**
 * 倒计时器
 */
public class CountDownLatchTest implements Runnable {
    public static CountDownLatch count = new CountDownLatch(10);
    public static CountDownLatchTest test = new CountDownLatchTest();

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            count.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(test).start();
        }
        count.await(); // 等待计数器为0
        System.out.println("fire");
    }
}