package leetcode.贪心算法;

/**
 * 描述:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * @author luokui
 * @create 2020-08-22 17:11
 */
public class L55_Solution {

    public boolean canJump(int[] nums) {
        int distant = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            distant = Math.max(i + nums[i], distant);
            if (distant <= i) {
                return false;
            }
        }
        return distant >= nums.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new L55_Solution().canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
