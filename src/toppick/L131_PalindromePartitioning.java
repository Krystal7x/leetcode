package toppick;

//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法 
// 👍 425 👎 0


import java.util.LinkedList;
import java.util.List;

//L131、分割回文串 ----
public class L131_PalindromePartitioning {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> partition(String s) {
            List<List<String>> ans = new LinkedList<>();
            if (s.length() == 0) return ans;
            LinkedList<String> list = new LinkedList<>();
            partition(s, 0, list, ans);
            return ans;
        }

        public void partition(String s, int start, LinkedList<String> list, List<List<String>> ans) {
            if (start >= s.length()) {
                ans.add(new LinkedList<>(list));
                return;
            }
            for (int i = start; i <= s.length(); i++) {
                if (isPartition(s.substring(start, i))) {
                    list.add(s.substring(start, i));
                    partition(s, i, list, ans);
                    list.removeLast();
                }

            }
        }

        boolean isPartition(String s) {
            if (s.length() == 0) return false;
            int left = 0;
            int right = s.length() - 1;
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L131_PalindromePartitioning().new Solution();

    }
}