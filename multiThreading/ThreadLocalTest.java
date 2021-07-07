package multiThreading;

public class ThreadLocalTest implements Runnable {
    private ThreadLocal<String> tl = new ThreadLocal<>();

    @Override
    public void run() {
        // 对每个线程设置独有的content变量
        setContent(Thread.currentThread().getName());
        System.out.println("-----------------");
        System.out.println(Thread.currentThread().getName() + getContent());
    }

    public static void main(String[] args) {
        // 下面的5个线程用到到都是同一个tl
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        // 开启多个线程，开启的多个线程，他们的id是不一样的，所以在tl种的数据不会相互覆盖
        for (int i = 0; i < 5; i++) {
            new Thread(threadLocalTest, "thread"+ i).start();
        }
    }

    public void setContent(String content) {
        tl.set(content);
    }

    public String getContent() {
        String ret = tl.get();
        tl.remove();
        return ret;
    }


}
