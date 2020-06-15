package leetcode.动态规划;

/**
 * 描述:四字键盘
 *
 * @author luokui
 * @create 2020-06-12 17:53
 */
public class L651_Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 0; i <= N; i++) {
            dp[i] = i;
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }

        }
        return dp[N];
    }
}
