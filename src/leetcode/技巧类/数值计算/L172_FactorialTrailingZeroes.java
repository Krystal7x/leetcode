package leetcode.技巧类.数值计算;

//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 367 👎 0


public class L172_FactorialTrailingZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 两个数相乘结果末尾有 0，一定是因为两个数中有因子 2 和 5，因为 10 = 2 x 5。
         * 也就是说，问题转化为：n! 最多可以分解出多少个因子 2 和 5
         * 比如说 n = 25，那么 25! 最多可以分解出几个 2 和 5 相乘？
         * 这个主要取决于能分解出几个因子 5，因为每个偶数都能分解出因子 2，因子 2 肯定比因子 5 多得多。
         * 25! 中 5 可以提供一个，10 可以提供一个，15 可以提供一个，20 可以提供一个，25 可以提供两个，总共有 6 个因子 5，
         * 所以 25! 的结果末尾就有 6 个 0。
         *
         * @param n
         * @return
         */
        public int trailingZeroes(int n) {
            int res = 0;
            long divisor = 5;
            while (divisor <= n) {
                res += n / divisor;
                divisor *= 5;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L172_FactorialTrailingZeroes().new Solution();

    }
}