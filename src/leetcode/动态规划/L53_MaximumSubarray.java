package leetcode.动态规划;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2410 👎 0

public class L53_MaximumSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 动态规划解法
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
            //dp[i]定义:以nums[i]结尾的子数组的最大值
            int[] dp = new int[nums.length];
            int ans = nums[0];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //只跟前一个值有关，可压缩
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L53_MaximumSubarray().new Solution();

    }
}