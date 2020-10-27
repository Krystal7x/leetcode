package hot100;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1385 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//L22、括号生成
public class L22_GenerateParentheses{
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)

    
    
	public static void main(String[] args) {
		Solution solution = new L22_GenerateParentheses().new Solution();
		
	}
}