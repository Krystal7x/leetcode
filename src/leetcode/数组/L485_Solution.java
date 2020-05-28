package leetcode.数组;

/**
 * 描述:
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * @author luokui
 * @create 2020-05-19 17:58
 */
public class L485_Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }
        int tmp = 0;
        for (int n : nums) {
            if (n == 0) {
                if (tmp > result) {
                    result = tmp;
                }
                tmp = 0;
            }
            if (n == 1) {
                tmp++;
            }

        }

        if (tmp > result) {
            result = tmp;
        }
        return result;
    }
}
