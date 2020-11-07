package hot100;

//删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。 
//
// 说明: 输入可能包含了除 ( 和 ) 以外的字符。 
//
// 示例 1: 
//
// 输入: "()())()"
//输出: ["()()()", "(())()"]
// 
//
// 示例 2: 
//
// 输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
// 
//
// 示例 3: 
//
// 输入: ")("
//输出: [""] 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 305 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//L301、删除无效的括号 ----
public class L301_RemoveInvalidParentheses {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            //1、先计算最少删除左括号和右括号的个数
            int left = 0, right = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != '(' && c != ')') continue;
                if (c == '(') {
                    left++;
                }
                if (c == ')') {
                    if (left > 0) {
                        left--;
                    } else {
                        right++;
                    }
                }
            }
            //回溯
            Set<String> ans = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            recurse(s, 0, left, right, 0, 0, sb, ans);
            return new LinkedList<>(ans);
        }

        /**
         * 回溯
         *
         * @param s
         * @param index      索引
         * @param remLeft    需要删除的左括号个数
         * @param remRight   需要删除的右括号个数
         * @param leftCount  目前的左括号个数
         * @param rightCount 目前的右括号个数
         * @param sb         栈
         */
        private void recurse(String s, int index, int remLeft, int remRight,
                             int leftCount, int rightCount, StringBuilder sb, Set<String> ans) {
            if (index == s.length()) {
                if (remLeft == 0 && remRight == 0) {
                    ans.add(sb.toString());
                }
            } else {
                char c = s.charAt(index);
                //1、第一种情况，删除，看下一个
                if ((c == '(' && remLeft > 0) || (c == ')' && remRight > 0)) {
                    recurse(s, index + 1,
                            c == '(' ? remLeft - 1 : remLeft,
                            c == ')' ? remRight - 1 : remRight,
                            leftCount, rightCount, sb, ans);
                }

                //2、当第一种情况递归完了后，看第二种情况，即不删
                sb.append(c);
                //2.1 其他字符
                if (c != '(' && c != ')') {
                    recurse(s, index + 1, remLeft, remRight, leftCount, rightCount, sb, ans);
                } else if (c == '(') {
                    //2.2左括号 直接加入，总数加一
                    recurse(s, index + 1, remLeft, remRight, leftCount + 1, rightCount, sb, ans);
                } else if (c == ')' && leftCount > rightCount) {
                    //2.2右括号时，leftCount必须大才有效
                    recurse(s, index + 1, remLeft, remRight, leftCount, rightCount + 1, sb, ans);
                }
                sb.deleteCharAt(sb.length() - 1);

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L301_RemoveInvalidParentheses().new Solution();
        System.out.println(solution.removeInvalidParentheses("()())()"));

    }
}