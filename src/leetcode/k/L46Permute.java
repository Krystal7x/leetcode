package leetcode.k;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther k
 * @date 2019-06-23 17:29
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */

public class L46Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(result, nums, 0);
        return result;
    }

    /**
     * 回溯法，经典！一定要记住
     * @param result
     * @param nums
     * @param first
     */
    public void backtrack(List<List<Integer>> result, int[] nums, int first){
        if(first == nums.length){
            addResult(result, nums);
        }
        for(int i = first; i < nums.length; i++){
            swap(nums, first, i);
            backtrack(result, nums, first+1);
            swap(nums, first, i);
        }

    }

    public void addResult(List<List<Integer>> result, int[] nums){
        ArrayList<Integer> l =new ArrayList<>();
        for(int i : nums){
            l.add(i);
        }
        result.add(l);
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
