package DataStructure.multithreading;

// 交替打印至100

public class Test2{

    public static void main(String[] args) throws InterruptedException {

        new Thread(new TurningRunner(), "奇数").start();
        new Thread(new TurningRunner(), "偶数").start();

    }

    static class TurningRunner implements Runnable {
        static int i = 0;
        static final Object lock = new Object();
        @Override
        public void run() {
            while (i <= 100) {
                synchronized(lock) {  // synchronized是随机抢锁的，如果不进行wait，则奇数的可能会多次抢到锁

                    lock.notify();

                    if (i < 100) {
                        i++;
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                        try {
                            lock.wait();
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }


//    static class TurningRunner implements Runnable {
//        private static int count = 1;
//        private static final Object lock = new Object();
//
//        @Override
//        public void run() {
//            while (count <= 100) {
//                synchronized (lock) {
//
//                    System.out.println(Thread.currentThread().getName() + ":" + count);
//                    count ++;
//
//                    //注意notify和wait顺序不能错
//                    lock.notify(); // 唤醒另一个线程
//
//                    if (count < 100) {
//                        try {
//                            lock.wait(); // 释放锁，进入阻塞状态，等待被唤醒
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                }
//            }
//        }
//    }
}

