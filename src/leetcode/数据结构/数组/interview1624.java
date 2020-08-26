package leetcode.数据结构.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 * <p>
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 *
 * @author luokui
 * @create 2020-05-27 20:29
 */
public class interview1624 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (j > i) {
            List<Integer> one = new ArrayList<>();
            if (nums[i] + nums[j] == target) {
                one.add(nums[i]);
                one.add(nums[j]);
                result.add(one);
                i++;
                j--;
            }
            if ((nums[i] + nums[j]) > target) {
                j--;
            }
            if ((nums[i] + nums[j]) < target) {
                i++;
            }
        }

        return result;
    }
}
