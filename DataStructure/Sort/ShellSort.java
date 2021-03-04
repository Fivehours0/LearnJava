package DataStructure.Sort;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 参考链接：https://blog.csdn.net/qq_39207948/article/details/80006224
 */
public class ShellSort {
    static int[] shellSort (int[] test) {

        int h = 1;
        // 确定最大的h值，使用的是2^k-1序列
        while (Math.pow(2, h+1) < test.length) {
            h++;
        }
        h = (int) (Math.pow(2, h) - 1);

        while (h != 0) {
            for (int i = h; i < test.length; i++) {
                int pos = i;
                while (pos-h >= 0) {
                    if (test[pos] < test[pos-h]) {
                        int tmp = test[pos];
                        test[pos] = test[pos-h];
                        test[pos-h] = tmp;
                        pos -= h;
                    } else break;
                }
            }
            h = h / 2;
        }
        return test;
    }

    public static void main(String[] args) {
//        int[] test = {3,2,1};
//        int[] test = {6, 1, 9, 3, 10};
        int[] test = {10,9,8,7,6,5,4,6,3,2,1,20,21,19,18,17,15,16,14,13,12,11};
        System.out.println(Arrays.toString(shellSort(test)));
    }
}

/**
 * 使用多线程方式实现希尔排序
 */
class ShellSortByThread implements Runnable {

    private final int[] data; // 数据，交换不冲突，是线程安全的，所以设置普通数组即可
    private final int pos; // 开始的位置
    private final int interval; // 间隔
    private final CountDownLatch count; // 计数器，一个interval需要进行多少次交换

    public ShellSortByThread (int[] data, int pos, int interval, CountDownLatch count) {
        this.data = data;
        this.pos = pos;
        this.interval = interval;
        this.count = count;
    }

    @Override
    public void run() {
        int current = pos;
        int before = pos-interval;
        while (before >= 0) {
            if (data[current] < data[before]) {
                int tmp = data[current];
                data[current] = data[before];
                data[before] = tmp;
                current = before;
                before = current - interval;
            } else break;
        }
        count.countDown();
    }

    static int[] shellSort (int[] test) {

        int h = 1;
        // 确定最大的h值，使用的是2^k-1序列
        while (Math.pow(2, h+1) < test.length) {
            h++;
        }
        h = (int) (Math.pow(2, h) - 1);

        while (h != 0) {
            CountDownLatch count = new CountDownLatch(test.length-h);
            for (int i = h; i < test.length; i++) {
                new Thread(new ShellSortByThread(test, i, h, count)).start();
            }

            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            h = h / 2;
        }
        return test;
    }

    public static void main(String[] args) {
//        int[] test = {3,2,1};
//        int[] test = {6, 1, 9, 3, 10};
        int[] test = {10,9,8,7,6,5,4,6,3,2,1,20,21,19,18,17,15,16,14,13,12,11};
        System.out.println(Arrays.toString(shellSort(test)));
    }
}
