package multiThreading;

/**
 * synchronize的3种用法
 *  1.指定加锁对象：对指定的对象加锁，进入同步代码前要获得给定对象的锁
 *  2.直接作用于实例方法：相当于对当前实例加锁，进入同步代码前要获得当前实例的锁
 *  3.直接作用于静态方法：相当于对当前类加锁，进入同步代码前要获得当前类的锁
 */
public class SynchronizedTest implements Runnable {
    private static int i = 0;
    private static final SynchronizedTest instance = new SynchronizedTest();

    /**
     * 指定加锁对象
     */
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            synchronized (instance) {
                i++;
            }
        }
    }



//    /**
//     * 用于实例方法, 也就是说，在调用实例方法的时候，需要获取实例的锁
//     * notice: 不要把 synchronized 加到 run 上了
//     */
//    private synchronized void increase () {
//        i++;
//    }
//
//    @Override
//    public void run() {
//        for (int j = 0; j < 10000; j++) {
//            increase();
//        }
//    }


//    /**
//     * 用于静态方法, 也就是说，在调用静态方法的时候，需要获取类的锁
//     * 即使在main中传入的是不同的实例，但只要实例的类相同就可以
//     *         Thread t1 = new Thread(new SynchronizedTest());
//     *         Thread t2 = new Thread(new SynchronizedTest());
//     */
//    private static synchronized void increase () {
//        i++;
//    }
//
//    @Override
//    public void run() {
//        for (int j = 0; j < 10000; j++) {
//            increase();
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
//        Thread t1 = new Thread(new SynchronizedTest());
//        Thread t2 = new Thread(new SynchronizedTest());
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
