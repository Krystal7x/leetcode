package leetcode.字符串;

//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 字符串 
// 👍 165 👎 0


public class L678_ValidParenthesisString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValidString(String s) {
            int left = 0;
            int right = 0;
            return checkValidString(s, 0, left, right);
        }

        private boolean checkValidString(String s, int start, int left, int right) {
            if (start > s.length() - 1 && left == right) return true;
            if (start > s.length() - 1 && left != right) return false;
            if (right > left) return false;

            char c = s.charAt(start);
            if (c == '(') {
                return checkValidString(s, start + 1, left + 1, right);
            }
            if (c == ')') {
                return checkValidString(s, start + 1, left, right + 1);
            }
            return checkValidString(s, start + 1, left, right)
                    || checkValidString(s, start + 1, left + 1, right)
                    || checkValidString(s, start + 1, left, right + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L678_ValidParenthesisString().new Solution();

    }
}