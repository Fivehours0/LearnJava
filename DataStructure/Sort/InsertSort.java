package DataStructure.Sort;

import java.util.Arrays;

public class InsertSort {
    /**
     * 插入排序
     *  1.保持数组0，1位置排序
     *  2。保持数组0，1，2位置排序
     *  以此类推
     *  第二步相较于第一步多出一个数字，所以如果2位置的数字比前面的小，前面的数字后移，给2位置的数字腾出空位。将2位置的数字插入合适的位置。
     * @param nums
     * @return
     */
    public static int[] insertSort(int[] nums) {
        int numsL = nums.length;
        for (int i = 1; i < numsL; i++) {
            int tmp = nums[i];
            int j = i;
            while (j != 0) {
                if (tmp < nums[j-1]) {
                    nums[j] = nums[j-1];
                    j--;
                } else break;
            }
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] test = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(insertSort(test)));
    }
}
