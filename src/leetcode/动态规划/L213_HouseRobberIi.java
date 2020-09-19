package leetcode.动态规划;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划 
// 👍 368 👎 0

public class L213_HouseRobberIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 环形数组一半将数组*2模拟,这里没用
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int length = nums.length;
            if (nums.length == 1) return nums[0];
            //1、第一个强，最后一个不强
            int max1 = rob2(nums, 1, length);
            //2、第一个不强，最后一个强
            int max2 = rob2(nums, 0, length - 1);
            return Math.max(max1, max2);
        }


        public int rob2(int[] list, int x, int y) {
            int nums[] = new int[list.length - 1];
            for (int i = 0; x < y; x++, i++) {
                nums[i] = list[x];
            }
            //dp含义:第i个时最大价值
            int[] rob = new int[nums.length + 1];

            rob[1] = nums[0];

            for (int i = 2; i <= nums.length; i++) {
                //第i个偷时的最大值
                //可压缩
                rob[i] = Math.max(rob[i - 2] + nums[i - 1], rob[i - 1]);
            }
            return rob[nums.length];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L213_HouseRobberIi().new Solution();

    }
}