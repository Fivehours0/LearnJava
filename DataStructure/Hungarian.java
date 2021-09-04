package DataStructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/c497247437534a75b6bb795a0f0fa663
 * 来源：牛客网
 *
 * A公司和B公司有n个合作的子项目，每个子项目由A公司和B公司各一名员工参与。一名员工可以参与多个子项目。
 *
 * 一个员工如果担任了该项目的项目经理，它需要对所参与的该项目负责。一个员工也可以负责多个项目。
 *
 * A公司和B公司需要保证所有子项目都能有人负责，问最少需要指定几名项目经理？
 *
 * 输入描述:
 * 第一行为A公司的的人员id列表， 0< id数量 < 10000，用空格切分
 * 第二行为B公司的人员id列表， 0< id数量 < 10000，用空格切分
 * 第三行为有已经有多少个匹配数子项目合作关系n
 * 下面有n行，每一行为每个子项目的合作对应关系，为两个id，第一个为A公司的员工id，第二个为B公司的员工id，用空格区分
 *
 *
 * 输出描述:
 * 一个整数，A公司和B公司合起来至少需要指定几名项目经理
 * 示例1
 * 输入
 * 0 1 2
 * 3 4 5
 * 6
 * 0 4
 * 0 3
 * 1 3
 * 1 4
 * 2 5
 * 2 4
 * 输出
 * 3
 */
public class Hungarian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] aId = sc.nextLine().trim().split(" ");
        String[] bId = sc.nextLine().trim().split(" ");
        int n = sc.nextInt();
        int total = aId.length + bId.length;
        // 由于id的范围没有说明，对id进行映射
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < aId.length; i++) {
            map.put(aId[i],i);
        }
        for (int j = 0; j < bId.length; j++) {
            map.put(bId[j], aId.length+j);
        }
        // 根据输入与映射的id，建立邻接图
        int[][] relation = new int[total][total];
        for (int i = 0; i < n; i++) {
            int posx = map.get(sc.next());
            int posy = map.get(sc.next());
            relation[posx][posy] = 1;
            relation[posy][posx] = 1;
        }

        boolean[] used = new boolean[total];
        int[] match = new int[total];
        Arrays.fill(match, -1);
        search(relation, match, used, total);

        int ans = 0;
        for (int i = 0; i < total; i++) {
            if (match[i] != -1) {
                ans++;
            }
        }
        System.out.println(ans/2);
    }

    private static void search (int[][] relation, int[] match, boolean[] used, int total) {
        for (int i = 0; i < total; i++) {
            if (match[i] == -1) {
                Arrays.fill(used, false);
                hungarian(relation, match, used, total, i);
            }
        }
    }

    private static boolean hungarian (int[][] relation, int[] match, boolean[] used, int total, int x) {
        for (int i = 0; i < total; i++) {
            if (relation[x][i] == 1 && !used[i]) {
                used[i] = true;
                // match[i] == -1表示当前节点还没有被别的点匹配
                // hungarian(relation, match, used, total, match[i]) 表示i当前已经被match[i]所匹配，这里让match[i]重新去匹配新的点
                // 如果匹配到了新的点，则将当前点i让给当前x
                if (match[i] == -1 || hungarian(relation, match, used, total, match[i])) {
                    match[x] = i;
                    match[i] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
