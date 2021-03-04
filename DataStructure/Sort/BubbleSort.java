package DataStructure.Sort;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort (int[] d) {
        int dLen = d.length;
        boolean flag = true; // 优化冒泡排序算法，如果在一次冒泡中，没有发生数字交换，则表名排序完成
        for (int i = 0; i < dLen; i++) {
            flag = true;
            for (int j = dLen - 1; j > i; j--) {
                if (d[j] < d[j - 1]) {
                    int tmp = d[j];
                    d[j] = d[j - 1];
                    d[j - 1] = tmp;
                    flag = false;
                }
            }
            if (flag) break;
        }
        return d;
    }

    public static void main(String[] args) {
        int[] test = {1, 4, 2, 9, 5, 6, 8, 7};
        System.out.println(Arrays.toString(bubbleSort(test)));
    }
}
