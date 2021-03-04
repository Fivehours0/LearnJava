package DataStructure.Sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * 快速排序
     *  找一个基准值(nums[0])，将比他小的数放到左边，比他大的数放到右边，当start==end的时候，交换num[0]和num[start](此时start=end)
     *  这样比基准值小的值都在其左边，比基准值大的都在其右边。对两边的数组重复上述操作
     * @param nums
     * @return
     */
    public static int[] quickSort (int[] nums, int start, int end) {
        if (start == end || end - start == 1) return nums;

        int base = start; // 快排基准点
        int left = start, right = end;
        while (left != right) {
            while (nums[right] >= nums[base] && left < right) right--;
            while (nums[left] <= nums[base] && left < right) left++;
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        int tmp = nums[base];
        nums[base] = nums[right]; // 此时start与end相等
        nums[right] = tmp;

        if (left == nums.length - 1) return nums;
        quickSort(nums, start, left);
        quickSort(nums, left+1, end);
        return nums;
    }

    public static void main(String[] args) {
        int[] test = {3,2,1};
//        int[] test = {6, 1, 9, 3, 10};
        System.out.println(Arrays.toString(quickSort(test, 0, test.length-1)));
//        int[] numsL = {1, 2, 3, 4};
//        int[] numsR = {2, 2, 3, 4};
//        int[] nums = Arrays.copyOf(numsL, numsL.length + numsR.length);
//        System.arraycopy(numsR, 0, nums, numsL.length, numsR.length);
//        System.out.println(Arrays.toString(nums));
    }
}
