package leetcode.字符串;

//你有一个单词列表 words 和一个模式 pattern，你想知道 words 中的哪些单词与模式匹配。 
//
// 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。 
//
// （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。） 
//
// 返回 words 中与给定模式匹配的单词列表。 
//
// 你可以按任何顺序返回答案。 
//
// 
//
// 示例： 
//
// 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//输出：["mee","aqq"]
//解释：
//"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
//"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
//因为 a 和 b 映射到同一个字母。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 50 
// 1 <= pattern.length = words[i].length <= 20 
// 
// Related Topics 字符串 
// 👍 74 👎 0


import java.util.LinkedList;
import java.util.List;

public class L890_FindAndReplacePattern {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> list = new LinkedList<>();
            for (String word : words) {
                if (isPattern(word, pattern)) {
                    list.add(word);
                }
            }
            return list;
        }

        boolean isPattern(String word, String pattern) {
            if (word.length() != pattern.length()) return false;
            //word向pattern 转
            int[] sign = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //说明之前匹配过
                if (sign[c - 'a'] != 0) {
                    if (sign[c - 'a'] != pattern.charAt(i)) return false;
                } else {
                    sign[c - 'a'] = pattern.charAt(i);
                }
            }
            for (int i = 0; i < word.length(); i++) {
                sign[i] = 0;
            }

            //pattern向 word 转
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                //说明之前匹配过
                if (sign[c - 'a'] != 0) {
                    if (sign[c - 'a'] != word.charAt(i)) return false;
                } else {
                    sign[c - 'a'] = word.charAt(i);
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L890_FindAndReplacePattern().new Solution();

    }
}