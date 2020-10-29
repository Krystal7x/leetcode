package hot100;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1775 👎 0


//L42、接雨水
public class L42_TrappingRainWater {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            if (height.length == 0) return 0;
            int[] left = new int[height.length];
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                max = Math.max(height[i], max);
                left[i] = Math.max(left[i], max);
            }
            int[] right = new int[height.length];
            max = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                max = Math.max(height[i], max);
                right[i] = Math.max(right[i], max);
            }
            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                ans += Math.min(left[i], right[i]) - height[i];
            }

            return ans;
        }

        /**
         * 双指针
         *
         * @param height
         * @return
         */
        int trap2(int[] height) {
            if (height == null || height.length == 0) return 0;
            int ans = 0;
            int left = 0;
            int right = height.length - 1;
            int l_max = height[left];
            int r_max = height[right];
            while (left < right) {
                l_max = Math.max(l_max, height[left]);
                r_max = Math.max(r_max, height[right]);
                if (l_max < r_max) {
                    ans += l_max - height[left];
                    left++;
                } else {
                    ans += r_max - height[right];
                    right--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L42_TrappingRainWater().new Solution();

    }
}