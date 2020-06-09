package leetcode.动态规划;

/**
 * 描述:
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * @author luokui
 * @create 2020-06-05 15:44
 */
public class L416_Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //奇数不会是true
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[sum + 1][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[0][i] = true;
        }
        for (int i = 0; i <= sum; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= nums.length; j++) {
                //j-1  表示nums的第几个数字
                if (nums[j - 1] > i) {
                    dp[i][j] = false;
                } else {
                    //不放 || 放
                    dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1];
                }
            }
        }


        return dp[sum][nums.length];
    }
}
