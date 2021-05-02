package toppick;

//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 
// 👍 347 👎 0


import java.util.HashMap;

//L205、同构字符串 ----
public class L205_IsomorphicStrings {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() == 0 && t.length() == 0) return true;
            if (s.length() != t.length()) return false;
            HashMap<Character, Character> map = new HashMap<>();
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(sChars[i])) {
                    if (!map.get(sChars[i]).equals(tChars[i])) {
                        return false;
                    }
                } else {
                    map.put(sChars[i], tChars[i]);
                }
            }
            map.clear();
            for (int i = 0; i < t.length(); i++) {
                if (map.containsKey(tChars[i])) {
                    if (!map.get(tChars[i]).equals(sChars[i])) {
                        return false;
                    }
                } else {
                    map.put(tChars[i], sChars[i]);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L205_IsomorphicStrings().new Solution();

        System.out.println(solution.isIsomorphic("paper", "title"));

    }
}