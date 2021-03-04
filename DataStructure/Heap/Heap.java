package DataStructure.Heap;

import java.util.Arrays;

public class Heap {
    private int[] data;

    public Heap (int[] arr) {
        this.data = arr.clone();
        buildHeap(this.data);
    }

    public int[] sort () {
        return sort(data);
    }

    /**
     * insert one node
     * @param val the val of node
     */
    public void insert (int val) {
        int dataL = data.length;
        int[] tmp = new int[dataL+1];
        System.arraycopy(data, 0, tmp, 0, dataL);
        data = tmp;
        data[dataL] = val;
        dataL = data.length;
        shiftUp(data, dataL-1, dataL);
    }

    /**
     * delete one node
     * @param index the index of node
     */
    public void delete (int index) {
        int dataL = data.length;
        swap(data, index, dataL - 1);
        int[] tmp = new int[dataL - 1];
        System.arraycopy(data, 0, tmp, 0, tmp.length);
        data = tmp;
        dataL = data.length;
        shiftUp(data, index, dataL);
        shiftDown(data, index, dataL);
    }

    private int[] sort (int[] arr) {
        int arrL = arr.length;
        int[] tmp = Arrays.copyOf(arr, arrL);
        int[] ans = new int[arrL];
        ans[0] = tmp[0];
        for (int i = arrL - 1; i > 0; i--) {
            swap(tmp, 0, i);
            shiftDown(tmp, 0, i);
            ans[arrL - i] = tmp[0];
        }

        return ans;
    }

    public int[] getData() {
        return data;
    }

    private void buildHeap (int[] arr) {
        int arrL = arr.length;

        // 除以2在减去1得到的是最后一个根节点的父节点位置
        int i = arrL / 2 - 1;
        while (i >= 0) {
            shiftDown(arr, i, arrL);
            i--;
        }
    }

    /**
     * 自底向上，将该node和他的左右孩子转换为堆结构. 如果结点的位置有发生变化，则自底向上继续调整，直至将所有的结点堆化
     * @param i the index of node
     * @param end index大于等于end的结点不处理
     */
    private void shiftUp (int[] arr, int i, int end) {
        int parent = (i - 1) / 2;
        int l = parent * 2 + 1;
        int r = parent * 2 + 2;

        // save the index of smallest value
        int smallest = getSmallest(arr, parent, l, r, end);
        if (smallest == parent) return;
        swap (arr, parent, smallest);
        shiftUp(arr, smallest, end);
    }

    /**
     * 自顶向下，将该node和他的左右孩子转换为堆结构. 如果结点的位置有发生变化，则自顶向下继续调整，直至将所有的结点堆化
     * @param i the index of node
     * @param end index大于等于end的结点不处理
     */
    private void shiftDown (int[] arr, int i, int end) {
        int l = left(i);
        int r = right(i);

        // save the index of smallest value
        int smallest = getSmallest(arr, i, l, r, end);
        if (smallest == i) return;
        swap (arr, i, smallest);
        shiftDown(arr, smallest, end);
    }

    /**
     * 找到3个结点中，值最小的那个
     * @param parent the index of first node
     * @param l the index of second node
     * @param r the index of third node
     * @param end index大于等于end的结点不处理
     * @return parent,l,r结点中，值最小的那个结点的index
     */
    private int getSmallest (int[] arr, int parent,int l ,int r, int end) {
        int smallest = parent;
        if (l < end && arr[l] <= arr[smallest])
            smallest = l;
        if (r < end && arr[r] <= arr[smallest])
            smallest = r;
        return smallest;
    }

    /**
     * swap the data in i and j
     * @param i the index of first number
     * @param j the index of second number
     */
    private void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     *
     * @param i the index of node
     * @return the index of the left child of the node
     */
    private int left (int i) {
        return 2 * i + 1;
    }

    /**
     *
     * @param i the index of node
     * @return the index of the right child of the node
     */
    private int right (int i) {
        return 2 * i + 2;
    }

    public static void main(String[] args) {
        int[] test = {5, 7, 3, 6, 1, 4};
        Heap h = new Heap(test);
        System.out.println(Arrays.toString(h.getData()));
        h.insert(8);
        System.out.println(Arrays.toString(h.getData()));
        h.delete(3);
        System.out.println(Arrays.toString(h.getData()));
        System.out.println(Arrays.toString(h.sort()));
    }
}
