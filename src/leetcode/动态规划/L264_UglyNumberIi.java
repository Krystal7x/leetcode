package leetcode.动态规划;

//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 379 👎 0

public class L264_UglyNumberIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            //dp[i]含义：第i个丑数
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int i2 = 0, i3 = 0, i5 = 0;
            for (int i = 2; i <= n; i++) {
                int n2 = dp[i2] * 2;
                int n3 = dp[i3] * 3;
                int n5 = dp[i5] * 5;
                dp[i] = Math.min(n2, Math.min(n3, n5));
                if (dp[i] == dp[i2] * 2) ++i2;
                if (dp[i] == dp[i3] * 3) ++i3;
                if (dp[i] == dp[i5] * 5) ++i5;
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L264_UglyNumberIi().new Solution();

    }
}