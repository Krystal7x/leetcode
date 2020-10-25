package sword;

//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 71 👎 0


public class S53_I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) return 0;
            int right = searchRight(nums, 0, nums.length - 1, target);
            int left = searchLeft(nums, 0, nums.length - 1, target);
            if (right == -1 || left == -1) return 0;


            return right - left + 1;
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
        Solution solution = new S53_I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();

    }
}