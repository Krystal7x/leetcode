package hot100;

//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 1040 👎 0


import java.util.Stack;

//L32、最长有效括号
public class L32_LongestValidParentheses {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            char[] chars = s.toCharArray();
            int[] arr = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') {
                    stack.push(i);
                } else if (stack.isEmpty()) {
                    arr[i] = 1;
                } else {
                    stack.pop();
                }
            }
            //遍历完字符数组，将未匹配的'('对应的标记数组的值置为1
            while (!stack.isEmpty())
                arr[stack.pop()] = 1;

            //计算0的长度就是最长有效
            int tmp = 0;
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    tmp = 0;
                    continue;
                }
                tmp++;
                ans = Math.max(tmp, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L32_LongestValidParentheses().new Solution();

    }
}