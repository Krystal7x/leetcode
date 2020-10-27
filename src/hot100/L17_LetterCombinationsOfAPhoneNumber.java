package hot100;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 973 👎 0


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//电话号码的字母组合
public class L17_LetterCombinationsOfAPhoneNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] s2 = new String[]{"a", "b", "c"};
        String[] s3 = new String[]{"d", "e", "f"};
        String[] s4 = new String[]{"g", "h", "i"};
        String[] s5 = new String[]{"j", "k", "l"};
        String[] s6 = new String[]{"m", "n", "o"};
        String[] s7 = new String[]{"p", "q", "r", "s"};
        String[] s8 = new String[]{"t", "u", "v"};
        String[] s9 = new String[]{"w", "x", "y", "z"};

        public List<String> letterCombinations(String digits) {
            List<String> ans = new LinkedList<>();
            if (digits.length() == 0) return ans;
            char[] chars = digits.toCharArray();
            Stack<String> stack = new Stack<>();
            letterCombinations(chars, 0, stack, ans);
            return ans;
        }

        void letterCombinations(char[] chars, int index, Stack<String> stack, List<String> ans) {
            if (index > chars.length - 1) {
                StringBuilder sb = new StringBuilder();
                for (String s : stack) {
                    sb.append(s);
                }
                ans.add(sb.toString());
                return;
            }
            String[] strings = getString(chars[index]);
            for (int i = 0; i < strings.length; i++) {
                stack.push(strings[i]);
                letterCombinations(chars, index + 1, stack, ans);
                stack.pop();

            }
        }

        String[] getString(char c) {
            switch (c) {
                case '2':
                    return s2;
                case '3':
                    return s3;
                case '4':
                    return s4;
                case '5':
                    return s5;
                case '6':
                    return s6;
                case '7':
                    return s7;
                case '8':
                    return s8;
                case '9':
                    return s9;
                default:
                    return null;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L17_LetterCombinationsOfAPhoneNumber().new Solution();

    }
}