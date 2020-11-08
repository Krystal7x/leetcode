package hot100;

//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 563 👎 0


import java.util.Stack;

//L394、字符串解码 ----
public class L394_DecodeString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            if (s == null || s.length() == 0) return "";
            Stack<Character> str = string2Stack(s);
            return decodeString(str);
        }

        public String decodeString(Stack<Character> str) {
            Stack<String> stack = new Stack<>();
            int n = 0;
            while (!str.isEmpty()) {
                Character c = str.pop();
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    stack.push(c.toString());
                    continue;
                }
                //数字
                if (Character.isDigit(c)) {
                    n = n * 10 + (c - '0');
                    continue;
                }
                //括号[
                if (c == '[') {
                    String s = decodeString(str);
                    for (int i = 0; i < n; i++) {
                        stack.push(s);
                    }
                    n = 0;
                }
                //字母
                //括号]
                if (c == ']') break;
            }

            return stack2String(stack);

        }

        public Stack<Character> string2Stack(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = s.length() - 1; i >= 0; i--) {
                stack.push(s.charAt(i));
            }
            return stack;
        }

        public String stack2String(Stack<String> stack) {
            StringBuilder sb = new StringBuilder();
            for (String s : stack) {
                sb.append(s);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L394_DecodeString().new Solution();
        System.out.println(solution.decodeString("abc3[cd]xyz"));

    }
}