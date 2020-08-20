package leetcode.技巧类.双指针;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * @author luokui
 * @create 2020-07-20 17:51
 */
public class L438_Solution {
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

    public static void main(String[] args) {
        String s = "aaabaaa";
        String p = "aaa";
        System.out.println(new L438_Solution().findAnagrams(s, p));


    }
}
