package leetcode.动态规划;

//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 393 👎 0

public class L416_PartitionEqualSubsetSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int length = nums.length;
            int target = 0;
            for (int n : nums) {
                target += n;
            }
            target = target / 2;
            //dp[i][j]:只有i个物品，容量是j的时候是否装满
            boolean[][] dp = new boolean[length + 1][target + 1];
            for (int i = 1; i <= length; i++) {
                for (int j = 1; j <= target; j++) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - nums[i - 1]];
                }
            }

            return dp[length][target];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L416_PartitionEqualSubsetSum().new Solution();

    }
}