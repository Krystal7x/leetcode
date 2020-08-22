package leetcode.贪心算法;

/**
 * 描述:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @author luokui
 * @create 2020-08-22 17:26
 */
public class L45_Solution {

    public int jump(int[] nums) {
        return jump(nums, nums.length - 1);
    }

    /**
     * 自己写的，感觉效率不差啊，
     *
     * @param nums
     * @param fin
     * @return
     */
    public int jump(int[] nums, int fin) {
        if (fin == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < fin; i++) {
            if (nums[i] + i >= fin) {
                index = i;
                break;
            }

        }
        return jump(nums, index) + 1;
    }


    /**
     * 贪心
     *
     * @param nums
     * @return
     */
    int jump2(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

}
