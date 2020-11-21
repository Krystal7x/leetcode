package toppick;

//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 644 👎 0


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//L127、单词接龙 ----
public class L127_WordLadder {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            LinkedList<String> queue = new LinkedList<>();
            queue.add(beginWord);
            int count = 1;
            while (!queue.isEmpty()) {
                count++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String s1 = queue.poll();
                    Iterator<String> iterator = wordList.iterator();
                    while (iterator.hasNext()) {
                        String s2 = iterator.next();
                        if (isWord(s1, s2)) {
                            if (s2.equals(endWord)) return count;
                            queue.add(s2);
                            iterator.remove();
                        }
                    }
                }
            }
            return 0;
        }

        boolean isWord(String s1, String s2) {
            int count = 0;
            if (s1.length() != s2.length()) return false;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) continue;
                count++;
            }
            return count == 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L127_WordLadder().new Solution();

    }
}