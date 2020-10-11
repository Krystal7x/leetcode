package leetcode.字符串;

//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串 
// 👍 16 👎 0


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Interview_1626_CalculatorLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Queue<Character> queue = Str2Queue(s);
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char sign = '+';
            while (!queue.isEmpty()) {
                Character poll = queue.poll();
                if (Character.isDigit(poll)) {
                    num = num * 10 + poll - '0';
                }
                if (!Character.isDigit(poll) || queue.isEmpty()) {
                    switch (sign) {
                        case '+':
                            Integer add = num;
                            stack.push(add);
                            break;
                        case '-':
                            Integer reduce = -num;
                            stack.push(reduce);
                            break;
                        case '*':
                            Integer multiply = stack.pop() * num;
                            stack.push(multiply);
                            break;
                        case '/':
                            Integer division = stack.pop() / num;
                            stack.push(division);
                            break;
                    }
                    sign = poll;
                    num = 0;
                }
            }

            return sum(stack);

        }


        private Queue<Character> Str2Queue(String s) {
            Queue<Character> queue = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    queue.add(s.charAt(i));
                }
            }
            return queue;
        }


        int sum(Stack<Integer> stack) {
            //计算所有数的和
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Interview_1626_CalculatorLcci().new Solution();

    }
}