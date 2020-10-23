package sword;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 45 👎 0


public class S14_II_JianShengZiIiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         *
         * @param n
         * @return
         */
        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 1;
            int sign = Integer.MAX_VALUE;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    //左边的最大值
                    int x = 0;
                    if (j > sign) {
                        x = Math.max(j, dp[j]);
                    } else {
                        x = dp[j];
                    }


                    //右边的最大值

                    int y = 0;
                    if (i - j > sign) {
                        y = Math.max(i - j, dp[i - j]);
                    } else {
                        y = dp[i - j];
                    }

                    if (i > sign) {
                        dp[i] = Math.max(x * y % 1000000007, dp[i]);
                    } else {
                        dp[i] = Math.max(x * y, dp[i]);
                    }

                }
                if (dp[i] >= 1000000007 && sign == Integer.MAX_VALUE) {
                    sign = i;
                    dp[i] = dp[i] % 1000000007;
                }
            }
            return dp[n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S14_II_JianShengZiIiLcof().new Solution();

    }
}