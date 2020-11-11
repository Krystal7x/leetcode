package hot100;

//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 401 👎 0


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//L438、找到字符串中所有字母异位词   -----
public class L438_FindAllAnagramsInAString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> findAnagrams(String s, String p) {


            List<Integer> ans = new LinkedList<>();
            if (s == null || s.length() == 0) {
                return ans;
            }
            char[] sc = s.toCharArray();
            Map<Character, Integer> window = new HashMap<>();

            char[] pc = p.toCharArray();
            Map<Character, Integer> need = new HashMap<>();

            for (int i = 0; i < pc.length; i++) {
                need.put(pc[i], need.getOrDefault(pc[i], 0) + 1);
            }
            int left = 0, right = 0, valid = 0;

            while (right < sc.length) {
                right++;
                window.put(sc[right - 1], window.getOrDefault(sc[right - 1], 0) + 1);
                if (need.get(sc[right - 1]) != null && need.get(sc[right - 1]).equals(window.get(sc[right - 1]))) {
                    valid++;
                }
                if (right - left == p.length()) {
                    if (valid == need.size()) {
                        ans.add(left);
                    }
                    if (need.get(sc[left]) != null && need.get(sc[left]).equals(window.get(sc[left]))) {
                        valid--;
                    }
                    window.put(sc[left], window.getOrDefault(sc[left], 0) - 1);
                    left++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L438_FindAllAnagramsInAString().new Solution();

    }
}