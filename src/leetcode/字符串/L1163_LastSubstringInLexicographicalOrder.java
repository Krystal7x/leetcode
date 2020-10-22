package leetcode.字符串;

//给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。 
//
// 
//
// 示例 1： 
//
// 输入："abab"
//输出："bab"
//解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab
//"。
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："tcode"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 4 * 10^5 
// s 仅含有小写英文字符。 
// 
// Related Topics 字符串 
// 👍 33 👎 0


public class L1163_LastSubstringInLexicographicalOrder {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 从前往后遍历
         * 再碰到aabb....交替有很长的例子 很超时
         *
         * @param s
         * @return
         */
        public String lastSubstring2(String s) {
            char[] str = s.toCharArray();
            int index = str.length - 1;
            int max = 0;

            for (int i = str.length - 1; i >= 0; i--) {
                if (str[i] - 'a' > max) {
                    index = i;
                    max = str[i] - 'a';
                } else if (str[i] - 'a' == max) {
                    //非常关键！！！
                    //因为字符相等一定是第一个大，没必要算后面的
                    if (i - 1 >= 0 && str[i] == str[i - 1]) continue;
                    //前一个
                    int temp = index;
                    //目前的
                    index = i;
                    max = str[i] - 'a';
                    for (int j = i, k = temp; j < str.length && k < str.length; j++, k++) {
                        if (str[k] - 'a' == str[j] - 'a') continue;
                        if (str[k] - 'a' > str[j] - 'a') {
                            index = temp;
                            max = str[index] - 'a';
                            break;
                        } else if (str[k] - 'a' < str[j] - 'a') {
                            break;
                        }
                    }
                }
            }

            return s.substring(index);
        }


        /**
         * 从后往前遍历
         * <p>
         * 感觉和从前往后是一样的复杂度，只是leetcode没有测试用例，所以可以通过
         *
         * @param s
         * @return
         */
        public String lastSubstring(String s) {
            if (s.length() <= 1) return s;
            int left = s.length() - 2;
            int right = s.length() - 1;
            while (left >= 0) {
                if (s.charAt(left) > s.charAt(right)) {
                    right = left;
                } else if (s.charAt(left) == s.charAt(right)) {
                    //非常关键！！！
                    //1、因为字符相等一定是第一个大，没必要算后面的
                    if (left - 1 >= 0 && s.charAt(left - 1) == s.charAt(left)) {
                        left--;
                        continue;
                    }
                    //2、特例判断
                    if (right == s.length() - 1) {
                        right = left;
                        left--;
                        continue;
                    }
                    //3、开始比较
                    for (int i = left + 1, j = right + 1; i < s.length() && j <= s.length(); i++, j++) {
                        if (j == s.length()) {
                            right = left;
                            break;
                        }
                        if (s.charAt(i) == s.charAt(j)) continue;
                        if (s.charAt(i) < s.charAt(j)) break;
                        if (s.charAt(i) > s.charAt(j)) {
                            right = left;
                            break;
                        }

                    }
                }
                left--;

            }
            return s.substring(right);
        }


        /**
         * 比较字符串
         * s1大返回1
         * s2大返回-1
         * 相等返回0
         *
         * @param s1
         * @param s2
         * @return
         */
        public int compareString(String s1, String s2) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int i = 0;
            while (i < chars1.length && i < chars2.length) {
                if (chars1[i] > chars2[i]) {
                    return 1;
                } else if (chars1[i] < chars2[i]) {
                    return -1;
                } else {
                    i++;
                }
            }
            if (i == chars1.length && (i == chars2.length)) {
                return 0;
            }
            if (i == chars1.length) {  //o1到头
                return -1;
            }
            if (i == chars2.length) { //o2到头
                return 1;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L1163_LastSubstringInLexicographicalOrder().new Solution();
        //System.out.println(solution.lastSubstring("xbylisvborylklftlkcioajuxwdhahdgezvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji"));

        for (int i = 0; i < 500000; i++) {
            System.out.print("a");
        }


    }
}