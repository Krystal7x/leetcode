package leetcode.数组;

/**
 * 描述:
 * 962. 最大宽度坡
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 * <p>
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 *
 * @author luokui
 * @create 2020-05-19 18:19
 */
public class L962_Solution {

    //双指针
    public int maxWidthRamp(int[] A) {
        int result = 0;
        if (A == null || A.length == 0) {
            return result;
        }
        int head = 0, tail = A.length - 1;

        for (int i = head; i < A.length && (tail - i) > result; i++) {
            for (int j = tail; j > i && (j - i) > result; j--) {
                if (A[j] >= A[i]) {
                    result = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
