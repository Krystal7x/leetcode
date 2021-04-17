package leetcode.字符串;

//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效的 IP 地址。 
//
// 
//
// 示例 1： 
//
// 输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 442 👎 0


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L93_RestoreIpAddresses {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            Stack<Integer> stack = new Stack<>();
            List<String> ans = new LinkedList<>();
            if (s.length() < 4) return ans;
            restoreIpAddresses(s, 0, stack, ans);
            return ans;
        }

        void restoreIpAddresses(String s, int start, Stack<Integer> stack, List<String> ans) {
            if (stack.size() >= 3) {
                if (start < s.length()) {
                    if (isActiveNum(s.substring(start))) {
                        ans.add(buildIp(s, stack));
                    }
                }
                return;
            }

            for (int i = start + 1; i <= s.length(); i++) {
                //不是简单的255，还有0开头的情况
                if (isActiveNum(s.substring(start, i))) {
                    stack.push(i);
                    restoreIpAddresses(s, i, stack, ans);
                    stack.pop();
                }
            }
        }

        boolean isActiveNum(String s) {
            if (s.length() < 2) return true;
            if (s.charAt(0) == '0') return false;
            if (s.length() > 3) return false;
            int n = Integer.parseInt(s);
            if (n <= 255) {
                return true;
            } else {
                return false;
            }

        }

        String buildIp(String s, Stack<Integer> stack) {
            StringBuilder sb = new StringBuilder();
            int pre = 0;
            for (int n : stack) {
                sb.append(s, pre, n);
                sb.append(".");
                pre = n;
            }
            sb.append(s.substring(pre));
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L93_RestoreIpAddresses().new Solution();

    }
}