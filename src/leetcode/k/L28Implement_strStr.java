package leetcode.k;


/**
 * @auther k
 * @date 2019-06-22 14:28
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 */

public class L28Implement_strStr {
    //傻逼方法
    public int strStr2(String haystack, String needle) {
        if(null == needle || needle.isEmpty()){
            return 0;
        }
        if(null == haystack || haystack.isEmpty()){
            return -1;
        }
        if(haystack.length() == needle.length()){
            return haystack.equals(needle)? 0 : -1;
        }

        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(needle.length() == 1){return i;}
                int tmp = i;
                for(int j = 1; j < needle.length(); j++){
                    if(haystack.charAt(tmp+j) != needle.charAt(j)){
                        break;
                    }
                    if(j == needle.length()-1){
                        return tmp;
                    }
                }
            }
        }
        return -1;
    }
    //双指针
    public int strStr(String haystack, String needle) {
        char[] hayArr = haystack.toCharArray();
        char[] needArr = needle.toCharArray();
        //主串(haystack)的位置
        int i = 0;
        //模式串(needle)的位置
        int j = 0;
        while (i < hayArr.length && j < needArr.length) {
            // 当两个字符相等则比较下一个
            if (hayArr[i] == needArr[j]) {
                i++;
                j++;
            } else {
                //回退
                i = i - j + 1;
                j = 0;
            }
        }
        //说明完全匹配
        if (j == needArr.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}
