package DataStructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/2f266ebdd8ab4408bb5e0c2240453c4c?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 网易严选建有N个自营仓分布在全国各地，标记为仓库1到N。
 * 给定一个配货时间组（v,u,w)，v为出发仓库，u为目标仓库，w为从出发仓库到目标仓库的耗时时间。可能存在仓库间过远，无法支持调拨转货。
 * 指定一个出发仓库K，我们需要将供应商发送到K仓库的货配送到各个仓库。问配送到所有可到达仓库所要最短时间？如果无法全部调拨到，则返回-1.
 *
 * 输入描述:
 * 第一行三个正整数，由空格分割，分别表示仓库个数N，出发仓K，以及配送时间组个数M
 * 接下来 M行，每行三个整数，由空格分割，分别表示（v,u,w)三个数，v为出发仓库，u为目标仓库，w为从出发仓库到目标仓库的耗时时间
 *
 *
 *
 * 输出描述:
 * 一行一个数字表示答案，配送到所有可达仓库到最短时间
 * 示例1
 * 输入
 * 6 2 5
 * 2 1 1
 * 2 6 2
 * 1 3 3
 * 3 4 1
 * 6 5 2
 * 输出
 * 5
 */
public class Dijskra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 仓库的个数
        int n = sc.nextInt();
        // 仓库的出发位置
        int k = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        // 建立花费表
        int[][] costs = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            String[] tmp = sc.nextLine().trim().split(" ");
            int posx = Integer.parseInt(tmp[0]);
            int posy = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);
            costs[posx][posy] = cost;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        boolean[] visited = new boolean[n+1];
        int[] min = new int[n+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[k] = 0;
        // 数组的第一个元素为起点到k点的最短距离0
        heap.add(new int[] {0, k});
        dijskra(costs, min, visited, n, heap);
        System.out.println(Arrays.toString(min));
        int ans = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < min.length; i++) {
            ans = Math.max(ans, min[i]);
            if (min[i] == Integer.MAX_VALUE) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    private static void dijskra (int[][] costs, int[] min, boolean[] visited, int n, PriorityQueue<int[]> heap) {
        if (heap.size() == 0) return;
        int[] tmp = heap.poll();
        int from = tmp[1];
        // 因为在更新堆的过程中，最短距离会更新，这时候就会往堆中插入序号相同的两组数据，会优先访问距离短的数据
        // 并将visited置为true，因此，只需要把访问过的在poll出来不处理就行
        while (visited[from]) {
            tmp = heap.poll();
            if (tmp == null) return;
            from = tmp[1];
        }
        int value = tmp[0];
        visited[from] = true;
        for (int i = 1; i < n+1; i++) {
            if (costs[from][i] != 0 && !visited[i]) {
                min[i] = Math.min(min[i], min[from] + costs[from][i]);
                heap.add(new int[] {min[i], i});
            }
        }

        dijskra(costs, min, visited, n, heap);
    }
}