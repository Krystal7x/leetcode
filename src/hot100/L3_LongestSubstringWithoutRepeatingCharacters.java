package hot100;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4439 👎 0


import java.util.HashMap;

public class L3_LongestSubstringWithoutRepeatingCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            int left = 0;
            int right = 0;
            int ans = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (right = 0; right < s.length(); right++) {
                //没有此字符
                if (map.get(s.charAt(right)) == null) {
                    map.put(s.charAt(right), right);
                } else {
                    for (int i = left; i <= right; i++) {
                        map.remove(s.charAt(i));
                        if (s.charAt(i) == s.charAt(right)) {
                            left = i + 1;
                            break;
                        }
                    }
                    map.put(s.charAt(right), right);
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L3_LongestSubstringWithoutRepeatingCharacters().new Solution();

    }
}