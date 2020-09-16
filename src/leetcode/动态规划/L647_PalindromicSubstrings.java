package leetcode.动态规划;

//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 391 👎 0


public class L647_PalindromicSubstrings {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力解法
         *
         * @param s
         * @return
         */
        public int countSubstrings(String s) {
            int count = 0;
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                count = count + count(arr, i, i);
                count = count + count(arr, i, i + 1);
            }
            return count;

        }

        public int count(char[] arr, int i, int j) {
            if (i < 0) return 0;
            if (j > arr.length - 1) return 0;
            int count = 0;
            int left = i;
            int right = j;
            while (arr[left] == arr[right]) {
                count++;
                left--;
                right++;
                if (left < 0 || right > arr.length - 1) return count;
            }
            return count;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L647_PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("aaabbb"));

    }
}