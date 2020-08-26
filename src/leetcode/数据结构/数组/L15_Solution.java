package leetcode.数据结构.数组;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author luokui
 * @create 2020-07-13 18:24
 */
public class L15_Solution {

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @param start
     * @return
     */
    List<List<Integer>> twoSumTarget(int[] nums, int target, int start) {
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

    /**
     * 三数之和
     *
     * @param nums
     * @param target
     * @return
     */
    List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; ) {
            int tmp = nums[i];
            List<List<Integer>> twoSumTarget = twoSumTarget(nums, target - tmp, i + 1);
            if (!twoSumTarget.isEmpty()) {
                for (int j = 0; j < twoSumTarget.size(); j++) {
                    twoSumTarget.get(j).add(tmp);
                    ans.add(twoSumTarget.get(j));
                }
            }
            while (i < nums.length && tmp == nums[i]) {
                i++;
            }

        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }

    public static void main(String[] args) {
        System.out.println(new L15_Solution().threeSum(new int[]{-4, -1, -4, 0, 2, -2, -4, -3, 2, -3, 2, 3, 3, -4}));
    }
}
