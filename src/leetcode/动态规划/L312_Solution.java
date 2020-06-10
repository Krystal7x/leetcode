package leetcode.动态规划;

/**
 * 描述:
 *
 * @author luokui
 * @create 2020-06-10 16:06
 */
public class L312_Solution {
    int maxCoins(int[] nums) {
        int length = nums.length;
        //加上头尾两个节点
        int[] tmp = new int[length + 2];
        tmp[0] = 1;
        tmp[length + 1] = 1;
        for (int i = 0; i < length; i++) {
            tmp[i + 1] = nums[i];
        }
        //开区间 i到j 的最大值
        int[][] dp = new int[length + 2][length + 2];
        //从下往上
        for (int i = length; i >= 0; i--) {
            //从左往右
            for (int j = i + 1; j < dp.length; j++) {
                //从i到j
                for (int k = i + 1; k < j; k++) {
                    // 择优做选择
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + tmp[i] * tmp[j] * tmp[k]
                    );
                }

            }
        }


        return dp[0][length + 1];
    }
}
