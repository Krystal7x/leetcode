package leetcode.动态规划;

//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
// 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 36 👎 0


public class interview0105_OneAwayLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 与72题一样
         *
         * @param first
         * @param second
         * @return
         */
        public boolean oneEditAway(String first, String second) {
            int l1 = first.length();
            int l2 = second.length();
            int[][] dp = new int[l1 + 1][l2 + 1];
            for (int i = 0; i < l1; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i < l2; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= l1; i++) {
                for (int j = 1; j <= l2; j++) {
                    if (first.charAt(i - 1) == second.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + 1);
                    }
                }
            }

            return dp[l1][l2] < 2;
        }

        private int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview0105_OneAwayLcci().new Solution();

    }
}