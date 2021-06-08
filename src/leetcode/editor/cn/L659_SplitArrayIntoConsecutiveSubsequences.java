package leetcode.editor.cn;

//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 示例 2： 
//
// 
//输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 示例 3： 
//
// 
//输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10000 
// 
// Related Topics 堆 贪心算法 
// 👍 304 👎 0


import java.util.HashMap;

//L659、分割数组为连续子序列 ----
public class L659_SplitArrayIntoConsecutiveSubsequences {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            if (nums.length < 3) {
                return false;
            }
            HashMap<Integer, Integer> freq = new HashMap<>();
            HashMap<Integer, Integer> need = new HashMap<>();
            for (int n : nums) {
                freq.put(n, freq.getOrDefault(n, 0) + 1);
            }
            for (int v : nums) {
                //1、已经被用到其他子序列中
                if (freq.get(v) == 0) {
                    continue;
                }
                //2、先判断 n 是否能接到其他子序列后面
                if (freq.get(v) > 0 && need.get(v) > 0) {
                    freq.put(v, freq.getOrDefault(v, 0) + 1);

                    // v 可以接到之前的某个序列后面
                    freq.put(v, freq.getOrDefault(v, 0) - 1);
                    // 对 v 的需求减一
                    need.put(v, need.getOrDefault(v, 0) - 1);
                    // 对 v + 1 的需求加一
                    need.put(v + 1, need.getOrDefault(v + 1, 0) + 1);
                }
                //3、将 v 作为开头，新建一个长度为 3 的子序列 [v,v+1,v+2]
                else if (freq.get(v) > 0 && freq.get(v + 1) > 0 && freq.get(v + 2) > 0) {
                    //
                    freq.put(v, freq.getOrDefault(v, 0) - 1);
                    freq.put(v + 1, freq.getOrDefault(v + 1, 0) - 1);
                    freq.put(v + 2, freq.getOrDefault(v + 2, 0) - 1);
                    // 对 v + 3 的需求加一
                    need.put(v + 3, need.getOrDefault(v + 3, 0) + 1);
                } else {
                    return false;
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L659_SplitArrayIntoConsecutiveSubsequences().new Solution();

    }
}