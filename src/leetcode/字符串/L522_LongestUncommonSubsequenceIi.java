package leetcode.字符串;

//给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。 
//
// 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。 
//
// 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。 
//
// 
//
// 示例： 
//
// 输入: "aba", "cdc", "eae"
//输出: 3
// 
//
// 
//
// 提示： 
//
// 
// 所有给定的字符串长度不会超过 10 。 
// 给定字符串列表的长度将在 [2, 50 ] 之间。 
// 
//
// 
// Related Topics 字符串 
// 👍 47 👎 0


import java.util.Arrays;

public class L522_LongestUncommonSubsequenceIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());
            for (int i = 0; i < strs.length; i++) {
                int j = 0;
                for (; j < strs.length; j++) {
                    if (j != i && isSub(strs[i], strs[j])) {
                        break;
                    }
                }
                if (j == strs.length) {
                    return strs[i].length();
                }
            }
            return -1;

        }

        /**
         * s1是不是s2的子序列
         *
         * @param s1
         * @param s2
         * @return
         */
        private boolean isSub(String s1, String s2) {
            if (s1.length() > s2.length()) return false;
            int l1 = 0;
            int l2 = 0;
            while (l1 < s1.length() && l2 < s2.length()) {
                if (s1.charAt(l1) == s2.charAt(l2)) {
                    l1++;
                    l2++;
                } else {
                    l2++;
                }
            }
            return l1 == s1.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L522_LongestUncommonSubsequenceIi().new Solution();

    }
}