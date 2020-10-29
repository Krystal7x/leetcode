package hot100;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 963 👎 0


import java.util.LinkedList;
import java.util.List;

//L46、全排列 ----
public class L46_Permutations {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new LinkedList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) {
                ans.add(new LinkedList<Integer>());
                return ans;
            }
            permute(nums, new LinkedList<>());
            return ans;

        }

        public void permute(int[] nums, List<Integer> stack) {
            if (stack.size() == nums.length) {
                ans.add(new LinkedList<>(stack));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (stack.contains(nums[i])) {
                    continue;
                }
                stack.add(nums[i]);
                permute(nums, stack);
                stack.remove(stack.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L46_Permutations().new Solution();

    }
}