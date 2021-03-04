package DataStructure.Sort;

import java.util.Arrays;

/**
 * 计数排序
 *  两大局限性
 *      1，当数列最大最小值差距过大时，并不适用于计数排序
 *      2，当数列元素不是整数时，并不适用于计数排序
 *
 * 参考链接
 * https://www.cnblogs.com/kyoner/p/10604781.html
 */
public class CountSort {
    public int[] countSort (int[] arr) {
        // 获得arr数组中的最大值
        int arrMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arrMax = Math.max(arrMax, arr[i]);
        }

        // 根据最大值确定统计数组的长度
        int[] count = new int[arrMax+1];

        // 遍历数组，填充统计数组
        for (int value : arr) {
            count[value]++;
        }

        // 遍历统计数组，生成结果
        int index = 0;
        int[] ans = new int[arr.length];
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                ans[index] = i;
                count[i]--;
                index++;
            }
        }
        return ans;
    }

    /**
     * 优化后的计数排序
     * 1. 以max - min作为统计数组的长度
     * 2. 优化后为稳定的排序算法
     * @return arr after sorted
     */
    public int[] optCountSort(int[] arr) {
        // 获得arr数组中的最大值和最小值
        int arrMax = arr[0], arrMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arrMax = Math.max(arrMax, arr[i]);
            arrMin = Math.min(arrMin, arr[i]);
        }

        // 根据最大值和最小值的差确定统计数组的长度
        int[] count = new int[arrMax - arrMin + 1];

        // 遍历数组，填充统计数组
        for (int value : arr) {
            count[value - arrMin]++;
        }

        // 统计数组变形，后面的元素等于前面的元素之和
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        // 遍历统计数组，生成结果
        int[] ans = new int[arr.length];
        for (int value : arr) {
            count[value - arrMin]--;
            int cnt = count[value - arrMin];
            ans[cnt] = value;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSort cs = new CountSort();
        int[] test = {9, 3, 5, 4, 9, 1, 2, 7, 8, 1, 3, 6, 5, 3, 4, 0, 10, 9, 7, 9};
        System.out.println(Arrays.toString(cs.countSort(test)));
        System.out.println(Arrays.toString(cs.optCountSort(test)));
    }
}
