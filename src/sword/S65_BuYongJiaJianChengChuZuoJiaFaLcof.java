package sword;

//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// 👍 78 👎 0


public class S65_BuYongJiaJianChengChuZuoJiaFaLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 使用二进制
         *
         * @param a
         * @param b
         * @return
         */
        public int add(int a, int b) {
            //直到不需要进位
            while (b != 0) {
                int c = (a & b) << 1;
                a = a ^ b;
                b = c;
            }
            return a;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S65_BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();

    }
}