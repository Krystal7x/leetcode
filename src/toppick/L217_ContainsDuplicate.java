package toppick;

//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 387 👎 0


import java.util.HashSet;

//L217、存在重复元素 ----
public class L217_ContainsDuplicate {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            return !notDuplicate(nums);
        }

        public boolean notDuplicate(int[] nums) {
            if (nums.length < 2) return true;
            HashSet<Integer> map = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.contains(nums[i])) return false;
                map.add(nums[i]);
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L217_ContainsDuplicate().new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,4,1}));

    }
}