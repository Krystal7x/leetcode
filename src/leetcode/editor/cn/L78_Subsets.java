package leetcode.editor.cn;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 857 👎 0


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//L78、子集 ----
public class L78_Subsets {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            if (nums == null || nums.length == 0) {
                ans.add(new LinkedList<Integer>());
                return ans;
            }
            subsets(nums, 0, new Stack<Integer>(), ans);
            return ans;

        }

        public void subsets(int[] nums, int start, Stack<Integer> stack, List<List<Integer>> ans) {
            ans.add(new LinkedList<Integer>(stack));
            for (int i = start; i < nums.length; i++) {
                stack.push(nums[i]);
                subsets(nums, i + 1, new Stack<Integer>(), ans);
                stack.pop();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L78_Subsets().new Solution();

    }
}