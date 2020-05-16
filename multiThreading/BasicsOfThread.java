package multiThreading;
/**
 * question
 * 为何涉及多线程，它能够给我带来什么
 * 程序、线程和进程的概念
 *      程序就是程序，现在编写的就是程序
 *      进程: 一个正在运行的程序，或者是程序的一次执行过程。进程是动态的，程序是静态的。如运行中的qq
 *      线程: 进程可以细化为多个并行执行的线程，
 * 何时需要多线程
 *      程序需要同时执行两个或多个任务
 *      需要一些后台运行的程序时
 *      要实现一些需要等待的任务时，如用户输入。在等待的过程中可以干点别的
 * 怎么用多线程
 *      创建线程的两种方式
 *      1.继承Thread类
 *      2.使用Runnable接口
 *          一般使用接口方式
 *              1.避免了单继承的局限性
 *              2.多个线程可以共享同一个实例(继承了runnable接口的对象的实例)
 *                实现thread对象(new Thread(target, name)), 这些对象则可同时共享该接口中的public变量, 非常适合多个相同线程来处理同一份数据
 *      Thread类方法:
 *          String getname()
 *          void setname()
 *          static currentThread() // 返回当前线程
 *          yield() // 让步, 当次线程取消放入线程队列, 重新从线程队列中选择一个线程执行
 *          join() // 等待当前进程死亡
 *          sleep() // 暂停线程
 *          stop() // 强制线程结束
 *          isAlive() // 判断线程是否存活
 *
 * 线程的优先级
 *      1.继承性: 线程A启动线程B，则A和B的优先级是一样的
 *      2.规则性: 线程会按照优先级大小顺序执行
 *      3.随机性: 优先级低的线程有概率优先执行
 * 优先级方法:
 *      getPriority()
 *      setPriority()
 *
 * 线程的同步与死锁
 *      线程安全问题：
 *          一个线程对多条语句只执行了一部分，还没有执行完，另一个线程也参与进来执行，导致共享数据出错。比如一个微信账户，一个支付宝账户，
 *      账户里只有1000，如果微信线程和支付宝线程同时取1000，那账户里不就为-1000了么。在取款方法中加入if判断当前余额也是没有用的，微信
 *      还没取完钱，支付宝线程开始执行就跳过判断了。
 *          这里阐述一下共享数据：
 *              只需要传入同一个类的对象，并在类中定义static变量，这样所有对象都可以共享static变量，从而达到线程中共享数据
 *              Thread t1 = new Thread(new ExamRunnable(), "t1")
 *              Thread t2 = new Thread(new ExamRunnable(), "t2")
 *      解决方法：
 *          通过synchronized同步锁来实现：public synchronized void draw
 *          让一个线程先执行完draw，执行过程中，其他线程不可以参与
 *          synchronized锁定的是对象，也就是说两个线程要操作同一个对象，同步锁才能发挥作用(线程操作不同的对象时，不同对象之间也是共享同一个
 *          static共享数据的)
 *          解决上述问题，可以使用public static synchronized void draw静态方法，将同步锁共享给所有的实例化对象
 *      线程死锁
 *
 * 继承Thread类
 */

class ExamThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "thread");
        }
    }

    public static void main(final String[] args) {
        ExamThread examThread = new ExamThread();
        examThread.start();
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
    }
}

/**
 * 使用Runnable创建线程
 */
class ExamRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // 使用Thread.currentThread().getName()获取当前线程名称
            System.out.println(Thread.currentThread().getName() + "thread");
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new ExamRunnable(), "t1"); // 可以传入线程的名称
        t1.start();
    }
}

public class BasicsOfThread extends Thread {
    public synchronized void draw(int monye){

    }
}