package hot100;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9459 👎 0


import java.util.HashMap;
import java.util.Map;

public class L1_TwoSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //map保存
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            Map<Integer, Integer> m = new HashMap<>();
            //两个值一样时，只会存后面的
            for (int i = 0; i < nums.length; i++) {
                m.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int targetNum = target - nums[i];
                if (m.containsKey(targetNum) && m.get(targetNum) != i) {
                    result[0] = i;
                    result[1] = m.get(targetNum);
                    return result;
                }
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L1_TwoSum().new Solution();

    }
}