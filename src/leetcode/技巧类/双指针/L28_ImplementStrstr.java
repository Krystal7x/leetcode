package leetcode.技巧类.双指针;

//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 602 👎 0


public class L28_ImplementStrstr {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L28_ImplementStrstr().new Solution();

    }
}