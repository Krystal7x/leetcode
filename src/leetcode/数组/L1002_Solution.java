package leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * @author k
 * @date 2020-05-17 15:21
 */

public class L1002_Solution {
    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0 || A.length == 1) {
            return null;
        }
        List<String> result = new ArrayList<>();
        //记录字符出现的次数
        int[] chars = new int[26];

        for (int i = 0; i < A.length; i++) {
            //第一个字符串，则先记录
            if (i == 0) {
                for (char a : A[i].toCharArray()) {
                    chars[a - 97]++;
                }

            } else {
                //第n个字符串，则先记录，后比较，取小的
                int[] tempChars = new int[26];
                for (char a : A[i].toCharArray()) {
                    tempChars[a - 97]++;
                }
                for (int n = 0; n < 26; n++) {
                    if (tempChars[n] < chars[n]) {
                        chars[n] = tempChars[n];
                    }
                }

            }
        }
        for (int n = 0; n < 26; n++) {
            for (int i = 0; i < chars[n]; i++) {
                Character c = (char) (n+97);
                result.add(c.toString());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println((char) 122);
    }
}
