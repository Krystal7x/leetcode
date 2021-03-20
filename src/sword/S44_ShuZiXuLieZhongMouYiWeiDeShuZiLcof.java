package sword;

//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 69 👎 0


public class S44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            //0    1个
            //1位数 9个 * 1
            //2位数 90个 * 2
            //3位数 900个 * 3
            if (n == 0) return 0;
            long tmp = 0;
            int base = 0;
            //1、找到在几位数
            while (tmp < n) {
                base++;
                tmp += 9 * Math.pow(10, base - 1) * base;
            }
            tmp -= 9 * Math.pow(10, base - 1) * base;
            int gap = Math.toIntExact(n - tmp);
            //落在数字几上
            long num = (int) Math.pow(10, base - 1) + (gap - 1) / base;
            char c = String.valueOf(num).charAt((gap - 1) % base);
            return c - '0';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        System.out.println(solution.findNthDigit(1000000000));

    }
}