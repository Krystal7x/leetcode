package leetcode.字符串;

/**
 * 描述:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * a-z:97-122,A-Z:65-90,0-9:48-57
 *
 * @author luokui
 * @create 2020-06-03 21:00
 */
public class L125_Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        char[] arr = s.toLowerCase().toCharArray();
        int begin = 0;
        int end = arr.length - 1;
        while (end >= begin) {
            if (!isChar(arr[begin])) {
                begin++;
                continue;
            }
            if (!isChar(arr[end])) {
                end--;
                continue;
            }
            if (arr[begin] != arr[end]) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    boolean isChar(char c) {
        if (c >= 97 && c <= 122) {
            return true;
        }
        if (c >= 65 && c <= 90) {
            return true;
        }
        if (c >= 48 && c <= 57) {
            return true;
        }
        return false;
    }
}

