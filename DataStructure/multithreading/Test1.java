package DataStructure.multithreading;

/**
 * 按顺序执行
 */
public class Test1 {
    private static volatile Test1 test;
    public static Test1 getInstance() {
        if (test == null) {
            synchronized (Test1.class) {
                if (test == null) {
                    test = new Test1();
                }
            }
        }
        return test;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3");
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}


