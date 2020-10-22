package leetcode.技巧类.数学;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1280 👎 0


public class L9_PalindromeNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用字符串
        public boolean isPalindrome(int x) {
            char[] sx = String.valueOf(x).toCharArray();
            if (sx.length == 0 || sx[0] == '-') {
                return false;
            }
            for (int i = 0; i < sx.length / 2; i++) {
                if (sx[i] != sx[sx.length - 1 - i]) {
                    return false;
                }
            }
            return true;
        }

        //不使用字符串
        public boolean isPalindrome2(int x) {
            int recover = 0;
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }
            if (x > recover) {
                recover = recover * 10 + x % 10;
                x = x / 10;
            }

            return x == recover || recover / 10 == x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L9_PalindromeNumber().new Solution();

    }
}