package leetcode.技巧类.双指针;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * @author luokui
 * @create 2020-07-20 17:42
 */
public class L567_Solution {
    boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();

        for (int i = 0; i < s1c.length; i++) {
            need.put(s1c[i], need.getOrDefault(s1c[i], 0) + 1);
        }
        int left = 0, right = 0, valid = 0;

        while (right < s2c.length) {
            window.put(s2c[right], window.getOrDefault(s2c[right], 0) + 1);
            if (need.get(s2c[right]) != null && need.get(s2c[right]).equals(window.get(s2c[right]))) {
                valid++;
            }
            while (valid == need.size()) {
                if ((right + 1 - left) == s1c.length) {
                    return true;
                }
                window.put(s2c[left], window.getOrDefault(s2c[left], 0) - 1);
                if (need.get(s2c[left]) != null && need.get(s2c[left]) > (window.get(s2c[left]))) {
                    valid--;
                }
                left++;
            }
            right++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new L567_Solution().checkInclusion("adc","dcda"));
    }
}
