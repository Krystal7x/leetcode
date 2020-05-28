package leetcode.数组;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 描述: 是53的进阶版
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * <p>
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。
 * （形式上，当0 <= i < A.length 时 C[i] = A[i]，而当 i >= 0 时 C[i+A.length] = C[i]）
 * <p>
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。
 * （形式上，对于子数组 C[i], C[i+1], ..., C[j]，
 * 不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 示例 2：
 * <p>
 * 输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 *
 * @author luokui
 * @create 2020-05-27 20:43
 */
public class L918_Solution {

    /**
     * 环形数组最大子数组和只会出现在两个地方
     * 1、数组内部：按53的方法计算
     * 2、跨数组了：那结果就等于所有数据和减去内部的最小数组和（特殊情况：全是负数，则取数组的最大值）
     *
     * @param A
     * @return
     */
    public int maxSubarraySumCircular(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
        }
        int max1 = maxSubArray(A);
        int min = minSubArray(A);
        int max2 = sum - min;
        if (max2 == 0) {
            max2 = A[0];
            for (int i = 0; i < A.length; i++) {
                max2 = Math.max(A[i], max2);
            }
        }
        return Math.max(max1, max2);
    }


    public int minSubArray(int[] nums) {
        int result = 0;
        int tmp = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        result = nums[0];
        tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp > 0) {
                tmp = nums[i];
                result = Math.min(tmp, result);
            } else {
                tmp = tmp + nums[i];
                result = Math.min(tmp, result);
            }
        }
        return result;
    }

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
                result = Math.max(tmp, result);
            } else {
                tmp = tmp + nums[i];
                result = Math.max(tmp, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new L918_Solution().maxSubarraySumCircular(new int[]{-1, -2, -3}));
    }
}
