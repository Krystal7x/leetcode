package sword;

//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 85 👎 0


public class S16_ShuZhiDeZhengShuCiFangLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double myPow(double x, int n1) {
            long n = n1;
            if (n == 0) {
                // 当指数为0底数为0时，没有意义，返回0或者返回1都可以
                return 1;
            } else if (n < 0) {
                if (x == 0) {
                    throw new RuntimeException("分母不能为0");
                }
                n = -n;
            }
            double res = PowerUnsignedExponent(x, n);
            return n1 < 0 ? 1 / res : res;
        }

        public double PowerUnsignedExponent(double x, long n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return x;
            }
            //2分递归
            double res = PowerUnsignedExponent(x, n / 2);
            res *= res;
            if (n % 2 == 1) {
                res *= x;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S16_ShuZhiDeZhengShuCiFangLcof().new Solution();

    }
}