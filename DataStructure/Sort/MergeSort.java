package DataStructure.Sort;

import java.util.Arrays;

public class MergeSort {
    /**
     * 归并排序，采用分治算法
     *
     * 参考链接：https://www.cnblogs.com/chengxiao/p/6194356.html
     * @param nums
     * @return
     */
    public static int[] mergeSort (int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private static int[] mergeSort (int[] nums, int left, int right) {
        if (right - left == 0) return Arrays.copyOfRange(nums, left, right+1);
        int mid = (left + right) / 2;
        int[] l = mergeSort(nums, left, mid);
        int[] r = mergeSort(nums, mid+1, right);
        return merge(l, r);
    }

    /**
     * 将左半部分有序数组和右半部分有序数组按照顺序进行合并
     * @param l 左半部分有序数组
     * @param r 右半部分有序数组
     * @return 合并好的有序数组
     */
    private static int[] merge (int[] l, int[] r) {
        int left = 0; // l数组指针
        int right = 0; // r数组指针
        int lLen = l.length, rLen = r.length;
        int[] ans = new int[lLen + rLen];
        while (left < lLen || right < rLen) {

            if (left < lLen) {
                if (right == rLen || l[left] <= r[right]) {
                    ans[left + right] = l[left];
                    left++;
                }
            }

            if (right < rLen) {
                if (left == lLen || l[left] > r[right]) {
                    ans[left + right] = r[right];
                    right++;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(mergeSort(test)));
    }
}
