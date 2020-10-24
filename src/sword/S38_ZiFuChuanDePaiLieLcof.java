package sword;

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 121 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class S38_ZiFuChuanDePaiLieLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            List<String> list = new LinkedList<>();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            permutation(chars, 0, list);
            String[] ans = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }

        private void permutation(char[] chars, int start, List<String> list) {
            if (start > chars.length - 1) {
                list.add(new String(chars));
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for (int i = start; i < chars.length; i++) {
                // 重复，因此剪枝!!!!
                if (set.contains(chars[i])) continue;
                set.add(chars[i]);
                swap(chars, start, i);
                permutation(chars, start + 1, list);
                swap(chars, start, i);
            }

        }

        private void swap(char[] chars, int start, int i) {
            char c = chars[start];
            chars[start] = chars[i];
            chars[i] = c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S38_ZiFuChuanDePaiLieLcof().new Solution();
        System.out.println(solution.permutation("abca"));

    }
}