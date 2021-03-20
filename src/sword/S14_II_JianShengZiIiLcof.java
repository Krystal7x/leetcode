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
                //////////////////
                //////////////////
                //////////////////
                if (dp[i] >= 1000000007 && sign == Integer.MAX_VALUE) {
                    sign = i;
                    dp[i] = dp[i] % 1000000007;
                }
            }
            return dp[n];

        }


        /**
         * 贪心
         * 我们首先考虑对于一段长n的绳子，我们可以切出的结果包含什么？
         * <p>
         * 1会包含吗？ 不会，因为1 * (k - 1) < k, 只要把1和任何一个其他的片段组合在一起就有个更大的值
         * 2可以
         * 3可以
         * 4可以吗？ 它拆成两个2的效果和本身一样，因此也不考虑
         * 5以上可以吗？ 不可以，这些绳子必须拆，因为总有一种拆法比不拆更优，比如拆成 k / 2 和 k - k / 2
         * <p>
         * 综上, 最后的结果只包含2和3(当然当总长度为2和3时单独处理), 那么很显然n >= 5时， 3*(n - 3) >= 2 * (n - 2) ，因此我们优先拆成3，最后剩余的拆成2。最后的结果一定是由若干个3和1或2个2组成.
         *
         * @param n
         * @return
         */
        public int cuttingRope2(int n) {
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            int mod = (int) 1e9 + 7;
            long res = 1;
            while (n > 4) {
                res *= 3;
                res %= mod;
                n -= 3;
            }
            return (int) (res * n % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S14_II_JianShengZiIiLcof().new Solution();

    }
}