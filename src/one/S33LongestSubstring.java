package one;

import java.util.HashMap;

/**
 * @auther k
 * @date 2019-06-22 15:55
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "abba"
 * 输出: 2
 *
 * 输入: "pwwkew"
 * 输出: 3
 */

public class S33LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(null ==s || s.isEmpty()){return 0;}
        int result = 0;
        //记录临时结果
        int tmp = 0;
        int begin = 0;
        HashMap<Character,Integer> box = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            if(box.get(new Character(s.charAt(i))) != null){
                begin = box.get(new Character(s.charAt(i))) > begin ?  box.get(new Character(s.charAt(i)))  : begin;
                tmp = i - begin;
                box.put(new Character(s.charAt(i)), i);
            }else{
                box.put(new Character(s.charAt(i)),i);
                tmp++;
            }
            if(tmp > result){
                result = tmp;
            }

        }
        return result;

    }
}
