package leetcode.数据结构.栈;

import java.util.Stack;

/**
 * 描述:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 *
 * @author luokui
 * @create 2020-08-24 11:52
 */
public class L20_Solution {

    //L20_Solution
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
