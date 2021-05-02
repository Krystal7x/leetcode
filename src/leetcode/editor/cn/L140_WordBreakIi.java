package leetcode.editor.cn;

//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法 
// 👍 445 👎 0


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//L140、单词拆分 II ----
public class L140_WordBreakIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         *
         * @param s
         * @param wordDict
         * @return
         */
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> ans = new LinkedList<>();
            if (s.length() == 0) return ans;
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && contains(s.substring(j, i), wordDict)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            Stack<String> stack = new Stack<>();
            wordBreak(s, dp, 0, wordDict, stack, ans);
            return ans;

        }

        /**
         * 回溯每一个断点
         *
         * @param s
         * @param dp
         * @param start
         * @param wordDict
         * @param stack
         * @param ans
         */
        public void wordBreak(String s, boolean[] dp, int start, List<String> wordDict,
                              Stack<String> stack, List<String> ans) {

            if (start + 1 >= dp.length) {
                ans.add(stack.toString());
            }
            for (int i = start + 1; i < dp.length; i++) {
                if (!dp[i]) continue;
                //1、选择切
                if (contains(s.substring(start, i), wordDict)) {
                    stack.push(s.substring(start, i));
                    wordBreak(s, dp, i, wordDict, stack, ans);
                    stack.pop();
                }
            }

        }

        private boolean contains(String substring, List<String> wordDict) {
            for (String word : wordDict) {
                if (word.equals(substring)) return true;
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L140_WordBreakIi().new Solution();
        List<String> wordDict = new LinkedList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");


        List<String> ans = solution.wordBreak("pineapplepenapple", wordDict);
        System.out.println(ans);

    }
}