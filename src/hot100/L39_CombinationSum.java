package hot100;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1018 👎 0


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//L39、组合总和
public class L39_CombinationSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new LinkedList<>();
            if (candidates.length == 0) return ans;
            Arrays.sort(candidates);
            Stack<Integer> stack = new Stack<>();
            combinationSum(candidates, 0, stack, 0, target, ans);
            return ans;
        }

        private void combinationSum(int[] candidates, int start, Stack<Integer> stack, int sum, int target, List<List<Integer>> ans) {
            if (sum > target) return;
            if (sum == target) {
                LinkedList<Integer> list = new LinkedList<>(stack);
                ans.add(list);
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                stack.push(candidates[i]);
                combinationSum(candidates, i, stack, sum + candidates[i], target, ans);
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L39_CombinationSum().new Solution();

    }
}