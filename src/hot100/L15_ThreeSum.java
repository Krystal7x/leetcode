package hot100;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2704 👎 0


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//三数之和
public class L15_ThreeSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            if (nums.length < 3) return ans;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                //去重
                if (i > 1 && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> two = twoSum(nums, -nums[i], i + 1);
                if (!two.isEmpty()) {
                    for (List<Integer> list : two) {
                        list.add(nums[i]);
                    }
                    ans.addAll(two);
                }

            }
            return ans;
        }


        List<List<Integer>> twoSum(int[] nums, int target, int start) {
            List<List<Integer>> ans = new LinkedList<>();
            int left = start;
            int right = nums.length - 1;
            while (left < right) {

                while (left < right && nums[left] + nums[right] < target) {
                    left++;
                }
                while (left < right && nums[left] + nums[right] > target) {
                    right--;
                }
                if (left < right && nums[left] + nums[right] == target) {
                    int l = nums[left];
                    int r = nums[right];
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    ans.add(tmp);

                    // 跳过所有重复的元素
                    while (left < right && nums[left] == l) left++;
                    while (left < right && nums[right] == r) right--;
                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L15_ThreeSum().new Solution();

    }
}