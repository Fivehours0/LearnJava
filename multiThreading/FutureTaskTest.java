package multiThreading;

import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Future模式的另一种用法在ThreadLockTest文件中
        FutureTask<String> future = new FutureTask<>(new RealData("A"));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(future); // 提高FutureTask
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        Thread.sleep(1000);
        System.out.println("future data: " + future.get()); // 若数据没有准备好，则会阻塞程序
        es.shutdown();
    }
}

class RealData implements Callable<String> {
    private final String data;
    public RealData (String a) {
        this.data = a;
    }

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append(data);
            Thread.sleep(1000);
        }
        return sb.toString();
    }
}
