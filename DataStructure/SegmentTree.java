package DataStructure;

import java.util.Arrays;

public class SegmentTree {
    private int[] nums;
    private int[] tree;
    public SegmentTree(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length * 4];
    }

    public void buildTree() {
        buildTree(0, nums.length-1, 1);
    }

    private void buildTree(int left, int right, int pos) {
        if (left == right) {
            tree[pos] = nums[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildTree(left, mid, pos * 2);
        buildTree(mid + 1, right, pos * 2 + 1);
        tree[pos] = tree[2*pos] + tree[2*pos+1];
    }

    public int[] getTree() {
        return tree;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        SegmentTree tree = new SegmentTree(nums);
        tree.buildTree();
        System.out.println(Arrays.toString(tree.getTree()));
    }
}
