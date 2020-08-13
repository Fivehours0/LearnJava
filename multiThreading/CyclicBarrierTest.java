package multiThreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    /**
     * 干活的大臣类，用以达到CyclicBarrier的计数值
     */
    public static class Minister implements Runnable {
        private int id;
        CyclicBarrier cyclic;

        Minister (CyclicBarrier cyclic, int id) {
            this.id = id;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                System.out.println("大臣" + id + "报道");
                cyclic.await(); // 等待所有大臣集合
                doSomething();
                cyclic.await(); // 等待所有大臣完成工作
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) { // 由等待在CyclicBarrier上的线程抛出，避免进行永久的，无所谓的等待(比如其中一个线程已经被中断，等待是无结果的)
                e.printStackTrace();
            }
        }

        public void doSomething () {
            try {
                Thread.sleep(1000);
                System.out.println("大臣" + id + "完成工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 皇帝类，当CyclicBarrier计数完成时执行
     */
    public static class Emperor implements Runnable {
        boolean flag;

        Emperor (boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (!flag) {
                System.out.println("大臣召集完毕");
                flag = true;
            } else System.out.println("大臣完工");
        }
    }

    public static void main(String[] args) {
        int N = 10;
        CyclicBarrier cyclic = new CyclicBarrier(N, new Emperor(false)); // 在申明时定义了计数完成执行哪个线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Minister(cyclic, i)).start();
        }
    }
}
