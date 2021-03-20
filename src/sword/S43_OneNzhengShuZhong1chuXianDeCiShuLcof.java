package sword;

//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 数学 
// 👍 101 👎 0


public class S43_OneNzhengShuZhong1chuXianDeCiShuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            if (n == 0) return 0;
            int digit = (int) Math.log10(n) + 1;
            int[][] dp = new int[digit + 1][2];
            //到个位的出现次数
            dp[1][0] = n % 10 >= 1 ? 1 : 0;
            //到9为止的出现次数
            dp[1][1] = 1;
            for (int i = 2; i <= digit; i++) {
                //取第n位数字
                int k = n / (int) (Math.pow(10, i - 1)) % 10;
                //1.1、*9出现几次 加  后几位出现几次
                dp[i][0] = k * dp[i - 1][1] + dp[i - 1][0];
                //1.2、再加上 n位 的k出现次数
                if (k == 1) {
                    dp[i][0] += n % (int) (Math.pow(10, i - 1)) + 1;
                }
                if (k > 1) {
                    dp[i][0] += Math.pow(10, i - 1);
                }
                //3、* 算9的次数   低位重复10次    高位是10的次方
                dp[i][1] = 10 * dp[i - 1][1] + (int) Math.pow(10, i - 1);

            }
            return dp[digit][0];


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S43_OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();

    }
}