package hot100;

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
// 👍 819 👎 0


//L152、乘积最大子数组 ----
public class L152_MaximumProductSubarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 因为负数的存在，所以最大得保持最大，最小两个变量
         *
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            if (nums.length == 0) return 0;
            int[] max = new int[nums.length];
            int[] min = new int[nums.length];
            max[0] = nums[0];
            min[0] = nums[0];
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                    min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
                } else {
                    max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                    min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
                }
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