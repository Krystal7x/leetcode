package leetcode.动态规划;

//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 415 👎 0


public class L494_TargetSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @param nums
         * @param S
         * @return
         */
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            if (S > sum) return 0;
            if ((sum + S) % 2 == 1) return 0;
            int target = (sum + S) / 2;
            int[][] dp = new int[nums.length + 1][target + 1];

            for (int i = 0; i <= nums.length; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j <= target; j++) {
                    if (j >= nums[i - 1]) {
                        dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }

            }
            return dp[nums.length][target];

        }

        /**
         * @param nums
         * @param S
         * @return
         */
        public int findTargetSumWays2(int[] nums, int S) {
            return findTargetSumWays2(nums, 0, S);
        }

        private int findTargetSumWays2(int[] nums, int start, int target) {
            int ans = 0;
            if (start >= nums.length - 1) {
                if (target - nums[start] == 0) ans++;
                if (target + nums[start] == 0) ans++;
                return ans;
            }
            int add = findTargetSumWays2(nums, start + 1, target - nums[start]);
            int reduce = findTargetSumWays2(nums, start + 1, target + nums[start]);
            return add + reduce;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L494_TargetSum().new Solution();

    }
}