package leetcode.动态规划;

/**
 * 描述:
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 * @author luokui
 * @create 2020-06-04 20:53
 */
public class interview0811 {
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 5, 10, 25};
        dp[0] = 1;
        //物品在外
        for (int coin : coins) {
            //容量
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
