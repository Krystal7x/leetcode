package leetcode.数据结构.数组;

/**
 * 描述:
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author luokui
 * @create 2020-05-20 15:22
 */
public class L53_Solution {
    public int maxSubArray(int[] nums) {
        int result = 0;
        int tmp = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        result = nums[0];
        tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp < 0) {
                tmp = nums[i];
                if (tmp > result) {
                    result = tmp;
                }
            } else {
                tmp = tmp + nums[i];
                if (tmp > result) {
                    result = tmp;
                }
            }


        }
        return result;
    }

}
