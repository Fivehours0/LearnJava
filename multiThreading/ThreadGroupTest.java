package multiThreading;

public class ThreadGroupTest implements Runnable {
    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + "  " + Thread.currentThread().getName();
        while (true) {
            System.out.println(groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("test"); // 创建线程组
        Thread t1 = new Thread(tg, new ThreadGroupTest(), "T1"); // 将t1线程加入tg
        Thread t2 = new Thread(tg, new ThreadGroupTest(), "T2"); // 将t1线程加入tg
        t1.start();t2.start();
        System.out.println(tg.activeCount()); // 获得活动线程的总数，但由于线程是动态的，所以获得的是一个估计值
        tg.list(); // 打印线程组中所有线程的信息
    }
}
