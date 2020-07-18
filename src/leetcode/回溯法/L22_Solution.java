package leetcode.回溯法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 描述:
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author luokui
 * @create 2020-06-30 11:19
 */
public class L22_Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n < 0) {
            return ans;
        }
        if (n == 0) {
            ans.add("");
            return ans;
        }
        Stack<Character> stack = new Stack<>();
        generateParenthesis(n, n, stack, ans);
        return ans;
    }

    public void generateParenthesis(int left, int right, Stack<Character> stack, List<String> ans) {
        if (left > right) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            ans.add(print(stack));
            return;
        }
        stack.push('(');
        generateParenthesis(left - 1, right, stack, ans);
        stack.pop();

        stack.push(')');
        generateParenthesis(left, right - 1, stack, ans);
        stack.pop();
    }

    public String print(Stack<Character> stack) {
        List<Character> list = new LinkedList<>(stack);

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }

}
