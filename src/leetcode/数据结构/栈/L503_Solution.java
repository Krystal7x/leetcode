package leetcode.数据结构.栈;

import java.util.Stack;

/**
 * 描述:
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
 * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * <p>
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * @author luokui
 * @create 2020-06-23 14:40
 */
public class L503_Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * length - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums[i % length]) {
                s.pop();
            }
            if (i <= length - 1) {
                ans[i] = s.empty() ? -1 : s.peek();
            }
            s.push(nums[i % length]);

        }
        return ans;

    }
}
