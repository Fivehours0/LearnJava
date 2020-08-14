package multiThreading;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getId() + "is working");
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(5),

                // 定义线程工厂，用以创建线程
//                Executors.defaultThreadFactory(), // 默认的线程工厂
                new ThreadFactory() { // 自定义的线程工厂
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        System.out.println("create" + t);
                        return t;
                    }
                },

                // 自定义拒绝策略
        new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + "is discard");
                    }
                }) {

            // same description of the methods of beforeExecute, afterExecute and terminated
            // This implementation does nothing, but may be customized in subclasses. Note: To properly nest multiple
            // overridings, subclasses should generally invoke super.beforeExecute at the end of this method.
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
                System.out.println("准备执行: " + Thread.currentThread().getId());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                System.out.println("执行完成" + Thread.currentThread().getId());
            }

            @Override
            protected void terminated() {
                super.terminated();
                System.out.println("线程终止");
            }
        };

        for (int i = 0; i < 5; i++) {
            es.execute(new ThreadPoolExecutorTest());
        }
        Thread.sleep(1000);
        es.shutdown();
    }
}

/**
 * 多线程本身容易引发不报错的错误，此处对这种错误进行追溯
 */
class SearchHeapStack implements Runnable {
    int a, b;

    public SearchHeapStack (int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a / b;
        System.out.println(re);
    }

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>());

        for (int i = 0; i < 5; i++) {
//            es.submit(new SearchHeapStack(100, i)); // 不会抛出异常
            es.execute(new SearchHeapStack(100, i)); // 抛出异常，但是异常堆栈追踪不到是这里调用的
        }
        es.shutdown();
    }
}

/**
 * 对上述进行改进，能够追踪到是哪个地方的调用导致了异常
 * 真厉害，牛逼！！！
 */
class TraceThreadPoolExecute extends ThreadPoolExecutor {

    public TraceThreadPoolExecute(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrace()));
    }

    private Exception clientTrace () {
        return new Exception("Client stack here");
    }

    private Runnable wrap (final Runnable r, final Exception clientStack) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    r.run();
                } catch (Exception e) {
                    clientStack.printStackTrace(); // 在此自己定义了一个异常，用以追溯到调用它的地方
                    throw e;
                }
            }
        };
    }

    public static void main(String[] args) {
        ExecutorService es = new TraceThreadPoolExecute(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>());
        for (int i = 0; i < 5; i++) {
            es.execute(new SearchHeapStack(100, i)); // 抛出异常，并追踪到这里
        }
        es.shutdown();
    }
}