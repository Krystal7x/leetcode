package leetcode.动态规划;

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 753 👎 0

import java.util.Stack;

public class L152_MaximumProductSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 感觉和53题一样的,但是不太懂
         *
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            int length = nums.length;
            int[] max = new int[length];
            int[] min = new int[length];
            max[0] = nums[0];
            min[0] = nums[0];
            for (int i = 1; i < length; ++i) {
                max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
                min[i] = Math.min(min[i - 1] * nums[i], Math.min(nums[i], max[i - 1] * nums[i]));
            }
            int ans = max[0];
            for (int i = 1; i < length; ++i) {
                ans = Math.max(ans, max[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L152_MaximumProductSubarray().new Solution();

    }
}