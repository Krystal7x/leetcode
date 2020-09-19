package leetcode.动态规划;

/**
 * 描述:
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 *
 * @author luokui
 * @create 2020-06-02 21:00
 */
public class L674_Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int result = 0;
        int pre = nums[0];
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                tmp++;
            } else {
                tmp = 1;
            }
            result = Math.max(result, tmp);
            pre = nums[i];
        }
        return result;

    }
}
