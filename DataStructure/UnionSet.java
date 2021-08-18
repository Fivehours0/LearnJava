package DataStructure;

import java.util.Arrays;

public class UnionSet {
    private int cap;
    private int[] roots;

    UnionSet(int cap) {
        this.cap = cap;
        this.roots = new int[cap];
        for (int i = 0; i < cap; i++) {
            roots[i] = -1;
        }
    }

    private int getParent(int x) {
        if (roots[x] == -1) {
            return x;
        } else {
            return getParent(roots[x]);
        }
    }

    private void setParent(int x, int parent) {
        roots[x] = parent;
    }

    private boolean union(int x1, int x2) {
        int rootX = getParent(x1);
        int rootY = getParent(x2);
        if (rootY == -1 && rootX == -1) {
            setParent(rootY, rootX);
            return true;
        } else if (rootX != rootY) {
            setParent(rootY, rootX);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] relation = new int[][] {{0,1}, {2,1}, {2,4}, {3,4}, {2,5}, {5,4}};
        UnionSet unionSet = new UnionSet(6);
        for (int[] ints: relation) {
            if(!unionSet.union(ints[0], ints[1])) {
                System.out.println("have circle");
            }
//            System.out.println(Arrays.toString(unionSet.roots));
        }

    }
}
