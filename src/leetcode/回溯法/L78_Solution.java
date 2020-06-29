package leetcode.回溯法;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 *
 * @author luokui
 * @create 2020-06-29 17:36
 */
public class L78_Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            ans.add(new LinkedList<Integer>());
            return ans;
        }
        subsets(new LinkedList<Integer>(), 0, nums);
        return ans;

    }

    public void subsets(List<Integer> stack, int start, int[] nums) {
        ans.add(new LinkedList<Integer>(stack));
        for (int i = start; i < nums.length; i++) {
            stack.add(nums[i]);
            subsets(stack, i + 1, nums);
            stack.remove(stack.size() - 1);
        }

    }
}
