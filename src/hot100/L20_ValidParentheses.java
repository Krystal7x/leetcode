package hot100;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1941 👎 0


import java.util.Stack;

//有效的括号
public class L20_ValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean isValid(String str) {
            if (str == null || str.length() == 0) {
                return true;
            }
            Stack<Character> stack = new Stack<>();
            stack.push(str.charAt(0));
            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                }
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L20_ValidParentheses().new Solution();

    }
}