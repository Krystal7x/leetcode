package sword;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
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
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 110 👎 0


import java.util.HashMap;
import java.util.Map;

public class S48_ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            int ans = 1;
            int left = 0;
            int right = 1;
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) + 1);
            while (right < s.length()) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                while (map.getOrDefault(s.charAt(right), 0) > 1) {
                    map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                    left++;
                }
                ans = Math.max(right - left + 1, ans);
                right++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S48_ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();

    }
}