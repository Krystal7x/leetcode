package leetcode.动态规划;

/**
 * 描述:
 * 抛硬币
 *
 * @author luokui
 * @create 2021-04-09 11:38 AM
 */
public class L1230 {

    class Solution {
        public double probabilityOfHeads(double[] prob, int target) {
            int n = prob.length;
            // dp[i][j] 表示前 i 个硬币中，j 个硬币朝上的概率
            double[][] dp = new double[n + 1][target + 1];
            // “一个硬币都没有，一个朝上的都没” 是确定事件，因此概率为 1
            dp[0][0] = 1.0;
            for (int i = 1; i <= n; i++) {
                // 给定的硬币全朝下
                dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= target; j++) {
                    dp[i][j] = dp[i - 1][j] * (1 - prob[i - 1]) + dp[i - 1][j - 1] * prob[i - 1];
                }
            }
            return dp[n][target];
        }
    }
}
