package leetcode.数据结构.数组;

/**
 * 在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。
 * （一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 * <p>
 * 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。
 * <p>
 * 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。
 * <p>
 * 如果无法做到，返回 -1.
 *
 * @author k
 * @date 2020-05-17 17:21
 */

public class L1007_Solution {

    public int minDominoRotations(int[] A, int[] B) {
        int result = -1;
        int length = A.length;
        for (int n = 1; n <= 6; n++) {
            int a = 0, b = 0;
            int tmpLength = length;
            for (int i = 0; i < length; i++) {
                if (A[i] == n && B[i] == n) {
                    tmpLength--;
                    continue;
                }
                if (A[i] == n) {
                    a++;
                    continue;
                }
                if (B[i] == n) {
                    b++;
                    continue;
                }
            }
            if ((a + b) == tmpLength) {
                int max = Math.max(a, b);
                if (result == -1) {
                    result = tmpLength - max;
                } else {
                    result = Math.min(tmpLength - max, result);
                }
            }
        }
        return result;
    }

}
