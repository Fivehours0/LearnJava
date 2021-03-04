package DataStructure.Sort;
import DataStructure.Heap.Heap;

import java.util.Arrays;

/**
 * 堆是具有以下性质的完全二叉树：
 *  每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
 *  或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
 *
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] test = {5, 2, 7, 3, 6, 1, 8, 4, 10, 9};
        Heap h = new Heap(test);
        System.out.println(Arrays.toString(h.sort()));
    }
}
