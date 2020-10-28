package hot100;

//给你一个升序排列的整数数组 nums ，和一个整数 target 。 
//
// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1037 👎 0


//L33、搜索旋转排序数组
public class L33_SearchInRotatedSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int rotate = searchRotate(nums);
            if (nums[rotate] == target) return rotate;
            if (rotate - 1 >= 0 && target >= nums[0] && target <= nums[rotate - 1]) {
                return search(nums, 0, rotate - 1, target);
            }
            if (target >= nums[rotate] && target <= nums[nums.length - 1]) {
                return search(nums, rotate, nums.length - 1, target);
            }
            return -1;
        }


        /**
         * 旋转点
         *
         * @param nums
         * @return
         */
        public int searchRotate(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (left + 1 == right) return right;
                int mid = (left + right) / 2;
                if (nums[mid] < nums[right]) {
                    right = mid;
                }
                if (nums[mid] > nums[left]) {
                    left = mid;
                }
            }
            return 0;
        }

        /**
         * 二分查找
         *
         * @param nums
         * @param left
         * @param right
         * @param target
         * @return
         */
        public int search(int[] nums, int left, int right, int target) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] < target) {
                    left = mid + 1;
                    continue;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                    continue;
                }
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L33_SearchInRotatedSortedArray().new Solution();
        solution.search(new int[]{9, 0, 2, 7, 8}, 3);

    }
}