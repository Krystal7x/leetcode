package leetcode.数据结构.栈;

import java.util.Stack;

/**
 * 描述:
 * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，
 * 其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * <p>
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
 * 如果不存在，对应位置输出 -1 。
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1
 *
 * @author luokui
 * @create 2020-06-23 12:17
 */
public class L496_Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] result = new int[l1];
        Stack<Integer> s = new Stack<>();
        for (int i = l2 - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            for (int j = 0; j < l1; j++) {
                if (nums1[j] == nums2[i]) {
                    result[j] = s.empty() ? -1 : s.peek();
                }
            }
            s.push(nums2[i]);
        }
        return result;
    }
}
