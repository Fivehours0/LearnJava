package DataStructure;


public class KMP {
    // 看的是灯哥的视频
    /**
     * 获取公共前缀。也可以理解为获取next数组
     * @param p 需要寻找的字符串
     * @return
     */
    private int[] getPrefix(String p) {
        int[] dp = new int[p.length()];
        dp[0] = -1;
        for (int i = 1, j = 0; i < p.length()-1; i++) {
            while (j > 0 && p.charAt(j) != p.charAt(i)) {
                j = dp[j];
            }
            if (p.charAt(j) == p.charAt(i)) {
                j++;
            }
            dp[i+1] = j;
        }
        // System.out.println(Arrays.toString(dp));
        return dp;
    }

    public boolean kmpSearch(String target, String p) {
        int[] prefix = getPrefix(p);
        int pPos = 0;
        for (int i = 0; i < target.length(); i++) {
            while (target.charAt(i) != p.charAt(pPos) && prefix[pPos] != -1) {
                pPos = prefix[pPos];
            }
            if (p.charAt(pPos) == target.charAt(i)) pPos++;
            if (pPos >= p.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
//        kmp.getPrefix("ababcabaa");
        System.out.println(kmp.kmpSearch("abababababaab", "ababcabaa"));
    }
}
