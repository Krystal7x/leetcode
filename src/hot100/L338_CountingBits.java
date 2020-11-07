package hot100;

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 441 👎 0


import java.util.LinkedList;
import java.util.List;

//L338、比特位计数 ----
public class L338_CountingBits {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力
         *
         * @param num
         * @return
         */
        public int[] countBits2(int num) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i <= num; i++) {
                int count = 0;
                int n = i;
                while (n != 0) {
                    n = n & (n - 1);
                    count++;
                }
                list.add(count);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }


        /**
         * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
         * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
         *
         * @param num
         * @return
         */
        public int[] countBits(int num) {
            int[] result = new int[num + 1];
            result[0] = 0;
            for (int i = 1; i <= num; i++) {
                if (i % 2 == 1) {
                    result[i] = result[i - 1] + 1;
                } else {
                    result[i] = result[i / 2];
                }
            }

            return result;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L338_CountingBits().new Solution();

    }
}