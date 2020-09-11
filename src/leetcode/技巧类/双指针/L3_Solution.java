package leetcode.技巧类.双指针;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author luokui
 * @create 2020-07-20 18:01
 */
public class L3_Solution {
    //还可以用动态规划来做，看L5
    int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        char[] sc = s.toCharArray();
        int left = 0, right = 0;

        while (right < sc.length) {
            right++;
            window.put(sc[right - 1], window.getOrDefault(sc[right - 1], 0) + 1);

            if (window.getOrDefault(sc[right - 1], 0) == 1) {
                if (right - left > ans) {
                    ans = right - left;
                }
            }
            while (window.getOrDefault(sc[right - 1], 0) > 1) {
                window.put(sc[left], window.getOrDefault(sc[left], 0) - 1);
                left++;
            }


        }

        return ans;
    }
}
