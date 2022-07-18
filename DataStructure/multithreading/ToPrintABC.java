package DataStructure.multithreading;
import java.util.concurrent.Semaphore;

public class ToPrintABC {
}



//public class ThreadTest {
//    private int times;
//    private Semaphore semaphoreA =new Semaphore(1);
//    private Semaphore semaphoreB =new Semaphore(0);
//    private Semaphore semaphoreC =new Semaphore(0);
//
//    public ThreadTest(int times) {
//        this.times=times;
//    }
//
//
//    public static void main(String[] args) {
//        ThreadTest PrintABC =new ThreadTest(3);
//        new Thread(PrintABC::printA).start();
//        new Thread(PrintABC::printB).start();
//        new Thread(PrintABC::printC).start();
//
//
//    }
//    public void printA() {
//        print("A",semaphoreA,semaphoreB);
//    }
//    public void printB() {
//        print("B",semaphoreB,semaphoreC);
//    }
//    public void printC() {
//        print("C",semaphoreC,semaphoreA);
//    }
//
//
//    public void print(String name,Semaphore current,Semaphore next) {
//        for(int i=0;i<times;i++) {
//            try {
//                current.acquire();
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            System.out.println(name);
//            next.release();
//        }
//
//    }
//}



//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class ThreadTest {
//    private static ReentrantLock lock = new ReentrantLock();
//    private static int count = 0;
//    private static Condition condition = lock.newCondition();
//
//    public static void main(String[] args) {
//        Thread A = new Thread(() -> {
//            //加锁 一次只有一个线程输出
//            lock.lock();
//            try {
//                while (true) {
//                    //因为只循环3次 所以到9的时候就结束循环
//                    if (count == 9) {
//                        break;
//                    }
//                    //当余数为0 就输出A
//                    if (count % 3 == 0) {
//                        count++;
//                        System.out.println("A");
//                        //唤醒其他等待线程
//                        condition.signalAll();
//                    } else {
//                        try {
//                            //等待
//                            condition.await();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            } finally {
//                lock.unlock();
//            }
//        });
//        Thread B = new Thread(() -> {
//            lock.lock();
//            try {
//                while (true) {
//                    if (count == 9) {
//                        break;
//                    }
//                    if (count % 3 == 1) {
//                        count++;
//                        System.out.println("B");
//                        condition.signalAll();
//                    } else {
//                        try {
//                            condition.await();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            } finally {
//                lock.unlock();
//            }
//        });
//        Thread C = new Thread(() -> {
//            lock.lock();
//            try {
//                while (true) {
//                    if (count == 9) {
//                        break;
//                    }
//                    if (count % 3 == 2) {
//                        count++;
//                        System.out.println("C");
//                        condition.signalAll();
//                    } else {
//                        try {
//                            condition.await();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            } finally {
//                lock.unlock();
//            }
//        });
//
//        A.start();
//        B.start();
//        C.start();
//
//    }
//}