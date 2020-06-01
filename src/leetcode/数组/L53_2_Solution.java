package leetcode.数组;

/**
 * 描述:
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
 * 请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * @author luokui
 * @create 2020-05-29 20:41
 */
public class L53_2_Solution {
    public int missingNumber(int[] nums) {

        if (nums[0] != 0) {
            return 0;
        }
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;

        }
        return 0;
    }
}
