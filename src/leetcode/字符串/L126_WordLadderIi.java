package leetcode.字符串;

//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
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
//wordList = ["hot100","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot100","dot","dog","cog"],
//  ["hit","hot100","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot100","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 353 👎 0


import java.util.*;

public class L126_WordLadderIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordList_set = new HashSet<>(wordList);
            List<List<String>> res = new ArrayList<>();
            Map<String, ArrayList<String>> next_word_map = new HashMap<>();
            Map<String, Integer> distance = new HashMap<>();

            bfs(beginWord, endWord, next_word_map, distance, wordList_set);
            dfs(beginWord, endWord, next_word_map, 0, res, new ArrayList<String>(Arrays.asList(beginWord)), distance);
            return res;
        }

        /**
         * @param beginWord
         * @param endWord
         * @param next_word_map 当前字符串可到的字符串
         * @param distance      记录到当前的最短路径
         * @param wordList_set  可选字符
         */
        private void bfs(String beginWord, String endWord, Map<String, ArrayList<String>> next_word_map, Map<String, Integer> distance, Set<String> wordList_set) {
            for (String s : wordList_set) next_word_map.put(s, new ArrayList<String>());

            next_word_map.put(beginWord, new ArrayList<>());

            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            distance.put(beginWord, 0);
            boolean flag = false;
            int step = 0;

            while (!queue.isEmpty()) {
                step++;
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    String word = queue.poll();
                    //当前字符可变的字符
                    for (String nw : next_word(word, wordList_set)) {
                        //加入当当前字符的路径中
                        next_word_map.getOrDefault(word, new ArrayList<>()).add(nw);
                        if (nw.equals(endWord)) flag = true;

                        //******最先到的一定是最短的！！！！******
                        if (!distance.containsKey(nw)) {
                            distance.put(nw, step);
                            queue.offer(nw);
                        }

                    }
                }
                if (flag) break;
            }
        }

        /**
         * @param beginWord
         * @param endWord
         * @param next_word_map
         * @param step
         * @param res
         * @param tmp           临时结果
         * @param distance
         */
        private void dfs(String beginWord, String endWord, Map<String, ArrayList<String>> next_word_map, int step,
                         List<List<String>> res, ArrayList<String> tmp, Map<String, Integer> distance) {
            if (tmp.get(tmp.size() - 1).equals(endWord)) res.add(new ArrayList<>(tmp));
            for (String word : next_word_map.get(tmp.get(tmp.size() - 1))) {
                tmp.add(word);
                if (distance.get(word) == step + 1) dfs(word, endWord, next_word_map, step + 1, res, tmp, distance);
                tmp.remove(tmp.size() - 1);
            }
        }


        /**
         * 可变成的下一个字符串 list
         *
         * @param word
         * @param wordList_set
         * @return
         */
        private ArrayList<String> next_word(String word, Set<String> wordList_set) {
            ArrayList<String> ans = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String tmp = new String(chars);
                    if (!tmp.equals(word) && wordList_set.contains(tmp))
                        ans.add(tmp);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L126_WordLadderIi().new Solution();
        LinkedList<String> lists = new LinkedList<>();
        lists.add("hot100");
        lists.add("dot");
        lists.add("dog");
        lists.add("lot");
        lists.add("log");
        lists.add("cog");
        System.out.println(solution.findLadders("hit", "cog", new LinkedList<String>()));

    }
}