package leetcode.技巧类.二分;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 722 👎 0


public class L35_SearchInsertPosition {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert1(int[] nums, int target) {
            if (null == nums || nums.length == 0) {
                return 0;
            }
            for (int i = 0; i < nums.length; i++) {
                if (target <= nums[i]) {
                    return i;
                }
            }
            return nums.length;
        }


        /**
         * 2分
         *
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            if (null == nums || nums.length == 0) {
                return 0;
            }
            int ans = -1;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                    ans = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                    ans = mid - 1;
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L35_SearchInsertPosition().new Solution();

    }
}