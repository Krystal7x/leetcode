package leetcode.技巧类.双指针;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:移动窗口
 *
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *
 *
 * @author luokui
 * @create 2020-07-15 16:28
 */
public class L76_Solution {
     String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        String ans = "";
        int ansLen = Integer.MAX_VALUE;
        int match = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), 1 + need.getOrDefault(t.charAt(i), 0));
        }
        while (right < s.length()) {
            Character r = s.charAt(right);
            if (need.containsKey(r)) {
                window.put(r, 1 + window.getOrDefault(r, 0));
                if (window.get(r).equals(need.get(r))) {
                    match++;
                }
            }
            while (match == need.size()) {
                if (right - left < ansLen) {
                    ans = s.substring(left, right + 1);
                    ansLen = right - left;
                }
                Character l = s.charAt(left);
                if (need.containsKey(l)) {
                    window.put(l, -1 + window.getOrDefault(l, 0));
                    if (window.get(l) < need.get(l)) {
                        match--;
                    }
                }
                left++;
            }

            right++;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new L76_Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
