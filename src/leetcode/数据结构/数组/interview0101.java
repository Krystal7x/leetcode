package leetcode.数据结构.数组;

/**
 * @author k
 * @date 2020-05-17 16:38
 */

public class interview0101 {
    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        int[] m = new int[128];
        char[] arr = astr.toCharArray();
        for (char c : arr) {
            m[c]++;
            if (m[c] != 1) {
                return false;
            }
        }
        return true;
    }
}
