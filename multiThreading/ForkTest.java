package multiThreading;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分治
 */
public class ForkTest extends RecursiveTask<Long> {
    long start = 0;
    long end = 0;

    public ForkTest (long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long diff = end - start;
        long sum = 0;
        if (diff <= 10000) {
            for (long i = start; i < end; i++) {
                sum += i;
            }
        } else { // 数字过大，进行fork
            ArrayList<ForkTest> saveTask = new ArrayList<>();
            long step = diff / 10;
            for (int i = 0; i < 10; i++) {
                long startPos = start + i * step; // 子任务的开始位置
                long endPos = Math.min(start + (i + 1) * step, end); // 子任务的结束位置
                ForkTest task = new ForkTest(startPos, endPos);
                saveTask.add(task);
                task.fork(); // 任务提交
            }

            for (ForkTest f: saveTask) {
                sum += f.join(); // return the computed result
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkTest tack = new ForkTest(0, 200000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> result = forkJoinPool.submit(tack); // 任务提交至线程池
        try {
            long res = result.get(); // 获取结果
            System.out.println(res);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}