package hot100;

//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组 
// 👍 433 👎 0


//L581、最短无序连续子数组 ---- 
public class L581_ShortestUnsortedContinuousSubarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            //无序数组中找最小元素
            boolean flag = false;
            for (int i = 1; i < nums.length; i++) {
                //第一个无序的地方
                if (nums[i] < nums[i - 1])
                    flag = true;
                if (flag)
                    //无序之后的最小值
                    min = Math.min(min, nums[i]);
            }
            //无序数组中找最大元素
            flag = false;
            for (int i = nums.length - 2; i >= 0; i--) {
                //第一个无序的地方
                if (nums[i] > nums[i + 1])
                    flag = true;
                if (flag)
                    //无序之后的最大值
                    max = Math.max(max, nums[i]);
            }
            //最小元素的位置
            int l = 0;
            int r = nums.length - 1;
            for (l = 0; l < nums.length; l++) {
                if (nums[l] > min)
                    break;
            }
            //最大元素的
            for (r = nums.length - 1; r >= 0; r--) {
                if (nums[r] < max)
                    break;
            }
            return r - l < 0 ? 0 : r - l + 1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L581_ShortestUnsortedContinuousSubarray().new Solution();

    }
}