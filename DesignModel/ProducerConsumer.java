package DesignModel;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PcData> queue = new LinkedBlockingQueue<>();
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ExecutorService executor = Executors.newFixedThreadPool(6);
        executor.submit(p1);
        executor.submit(p2);
        executor.submit(p3);
        executor.submit(c1);
        executor.submit(c2);
        executor.submit(c3);
        Thread.sleep(10 * 1000);
        p1.stop();
        p2.stop();
        p3.stop();
        Thread.sleep(10000);
        System.out.println("end");
        executor.shutdownNow();
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private final BlockingQueue<PcData> queue;
    private static final Random r = new Random();
    private static final Integer SLEEP = 1000;
    private static final AtomicInteger count = new AtomicInteger();

    public Producer (BlockingQueue<PcData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEP));
                PcData data = new PcData(count.incrementAndGet()); // 生产新的数据
                if (!queue.offer(data)) { // 向阻塞队列提交新的数据
                    System.out.println("offer data: " + data + " is failed");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop () {
        isRunning = false;
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    private final BlockingQueue<PcData> queue;
    private static final Random r = new Random();
    private static final Integer SLEEP = 1000;

    public Consumer (BlockingQueue<PcData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                PcData data = queue.poll(); // 从阻塞队列中拿到数据
                if (data != null) { // 如果拿到数据，则对数据进行处理
                    int value = data.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", value, value, value * value));
                }
                Thread.sleep(r.nextInt(SLEEP));
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

/**
 * 传输数据的格式
 */
class PcData {
    private final int data;
    public PcData (int value) {
        this.data = value;
    }

    @Override
    public String toString() {
        return "PcData{" + "data=" + data + '}';
    }

    public int getData() {
        return data;
    }
}