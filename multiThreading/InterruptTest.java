package multiThreading;

public class InterruptTest implements Runnable{
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("current thread is terminated");
                break;
            }
            System.out.println("running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("sleeping now");
                Thread.currentThread().interrupt(); // 重新设置中断状态
            }
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new InterruptTest(), "t");
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
