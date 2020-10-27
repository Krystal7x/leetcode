package hot100;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 640 👎 0


//L34、在排序数组中查找元素的第一个和最后一个位置
public class L34_FindFirstAndLastPositionOfElementInSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0) return new int[0];
            int right = searchRight(nums, 0, nums.length - 1, target);
            int left = searchLeft(nums, 0, nums.length - 1, target);
            if (right == -1 || left == -1) return new int[0];

            int[] ans = new int[2];
            ans[0] = left;
            ans[1] = right;
            return ans;
        }

        private int searchLeft(int[] nums, int left, int right, int target) {
            while (left <= right) {
                if (right == left) {
                    if (nums[left] != target) break;
                    return left;
                }
                if (right - left == 1) {
                    if (nums[left] == target) return left;
                    return right;
                }
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) right = mid;
                if (nums[mid] < target) left = mid;
            }
            return -1;
        }

        private int searchRight(int[] nums, int left, int right, int target) {
            while (left <= right) {
                if (right == left) {
                    if (nums[right] != target) break;
                    return right;
                }
                if (right - left == 1) {
                    if (nums[right] == target) return right;
                    return left;
                }
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) right = mid;
                if (nums[mid] <= target) left = mid;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();

    }
}