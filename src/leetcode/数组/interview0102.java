package leetcode.数组;


import com.sun.prism.es2.ES2Graphics;

import javax.lang.model.util.ElementScanner6;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * @author k
 * @date 2020-05-17 16:19
 */

public class interview0102 {

    //暴力
/*    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        Map<Character, Integer> m = new HashMap<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (char c : c1) {
            if (m.containsKey(c)) {
                int num = m.get(c) + 1;
                m.put(c, num);
            } else {
                m.put(c, 1);
            }
        }
        for (char c : c2) {
            if (m.containsKey(c)) {
                int num = m.get(c) - 1;
                m.put(c, num);
            } else {
                return false;
            }
        }
        for (char c : m.keySet()) {
            if (m.get(c) != 0) {
                return false;
            }
        }
        return true;
    }*/



}
