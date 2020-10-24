package sword;

//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 152 👎 0


public class S42_LianXuZiShuZuDeZuiDaHeLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            //int[] dp = new int[nums.length];
            int ans = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum >= 0) {
                    //dp[i] = dp[i - 1] + nums[i]
                    sum = sum + nums[i];
                    ans = Math.max(sum, ans);
                } else {
                    sum = nums[i];
                    ans = Math.max(sum, ans);
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S42_LianXuZiShuZuDeZuiDaHeLcof().new Solution();

    }
}