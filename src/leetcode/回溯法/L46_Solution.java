package leetcode.回溯法;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *
 * @author luokui
 * @create 2020-06-29 17:51
 */
public class L46_Solution {
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
