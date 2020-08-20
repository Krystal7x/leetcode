package leetcode.字符串;

import java.util.Stack;

/**
 * 描述:
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * @author luokui
 * @create 2020-07-24 18:06
 */
public class L224_Solution {
    int calculate(String s) {
        Stack<Character> stack = str2stack(s);
        return calculate(stack);
    }

    int calculate(Stack<Character> s) {
        Stack<Integer> sumStack = new Stack<>();
        char sign = '+';
        int num = 0;
        while (!s.isEmpty()) {
            char c = s.pop();

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = calculate(s);
            }
            if (!Character.isDigit(c) || s.isEmpty()) {
                switch (sign) {
                    case '+':
                        sumStack.push(num);
                        break;
                    case '-':
                        sumStack.push(-num);
                        break;
                    case '*':
                        sumStack.push(sumStack.pop() * num);
                        break;
                    case '/':
                        sumStack.push(sumStack.pop() / num);
                        break;
                }
                num = 0;
                sign = c;
            }
            if (c == ')') {
                break;
            }

        }
        return sum(sumStack);
    }

    Stack<Character> str2stack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                stack.push(c);
            }
        }
        return stack;
    }

    int sum(Stack<Integer> stack) {
        //计算所有数的和
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new L224_Solution().calculate("1 + 1"));
    }

}
