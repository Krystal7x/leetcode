package leetcode.动态规划;

//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
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
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 107 👎 0


public class Sword14_JianShengZiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            //dp含义，n划分之后的最大乘积
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    //dp[j]进去之后又会划分，且已经算过了
                    //要么继续划分，那么就分为2份
                    int a1 = j;
                    int a2 = i - j;
                    int a3 = dp[j];
                    int a4 = dp[i - j];

                    int b1 = Math.max(a1, a3);
                    int b2 = Math.max(a2, a4);

                    dp[i] = Math.max(dp[i], b1 * b2);
                }

            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Sword14_JianShengZiLcof().new Solution();
        System.out.println(solution.cuttingRope(8));

    }
}