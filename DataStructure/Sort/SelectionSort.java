package DataStructure.Sort;

import java.util.Arrays;

public class SelectionSort {
    /**
     * 选择排序:
     *  每一次遍历，选择一个数组中最小的，与数组前面的值交换位置
     *  -------------------------------------------------------
     *
     * 第一趟排序： 原始数据：5  2  8  4  9  1
     *
     * 最小数据1，把1放在首位，也就是1和5互换位置，
     *
     * 排序结果：1  2  8  4  9  5
     *
     * -------------------------------------------------------
     *
     * 第二趟排序：
     *
     * 第1以外的数据{2  8  4  9  5}进行比较，2最小，
     *
     * 排序结果：1  2  8  4  9  5
     *
     * -------------------------------------------------------
     *
     * 第三趟排序：
     *
     * 除1、2以外的数据{8  4  9  5}进行比较，4最小，8和4交换
     *
     * 排序结果：1  2  4  8  9  5
     *
     * -------------------------------------------------------
     *
     * 第四趟排序：
     *
     * 除第1、2、4以外的其他数据{8  9  5}进行比较，5最小，8和5交换
     *
     * 排序结果：1  2  4  5  9  8
     *
     * -------------------------------------------------------
     *
     * 第五趟排序：
     *
     * 除第1、2、4、5以外的其他数据{9  8}进行比较，8最小，8和9交换
     *
     * 排序结果：1  2  4  5  8  9
     *
     * -------------------------------------------------------
     * @param nums
     * @return
     */
    public static int[] selectionSort (int[] nums) {
        System.out.println("排序前: ");
        System.out.println(Arrays.toString(nums));

        int numsLen = nums.length;
        for (int i = 0; i < numsLen - 1; i++) {
            int k = i;
            for (int j = i + 1; j < numsLen; j++) {
                if (nums[k] > nums[j]) k = j;
            }
            if (i != k) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
            }
        }

        System.out.println("排序后: ");
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void main(String[] args) {
        int[] test = {12, 10, 11, 7, 6, 5, 4, 3, 2, 1};
        selectionSort(test);
    }
}
