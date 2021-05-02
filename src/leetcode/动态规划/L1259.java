package leetcode.动态规划;

/**
 * 描述:
 *
 * @author luokui
 * @create 2021-04-09 2:16 PM
 */
public class L1259 {
    class Solution {
        /**
         * 第 1 个人和第 k 个人握手（k = 4、6、8、…、n-2） ，会让 [2,k-1] 和 [k+1,n] 分别自成一圈，
         * 其中，[2,k-1] 总共有 k-1-2+1 = k-2 个人，[k+1,n] 总共有 n-(k+1)+1 = n-k 个人，
         * 因此，对于每一个 k ，都有 dp[k-2] × dp[n-k] 种握手数。
         *
         * @param num_people
         * @return
         */
        int numberOfWays(int num_people) {
            if (num_people == 2) return 1;
            if (num_people == 4) return 2;
            int[] dp = new int[num_people + 1];
            dp[0] = 1;
            dp[2] = 1;
            dp[4] = 2;
            for (int i = 6; i <= num_people; i += 2) {
                //不管谁和谁握手，直接分成2个人群就好
                for (int j = 0; j < i / 2; j++) {
                    //2 * j个人 和 i - 2 - 2 * j 个人
                    dp[i] = (dp[i] + dp[2 * j] * dp[i - 2 - 2 * j]) % 1000000007;
                }
            }
            return dp[num_people];
        }
    }

}
