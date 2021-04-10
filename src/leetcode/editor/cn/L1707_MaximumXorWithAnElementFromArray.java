package leetcode.editor.cn;

//给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。 
//
// 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR
// xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。 
//
// 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个
//查询的答案。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
//输出：[3,3,7]
//解释：
//1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
//2) 1 XOR 2 = 3.
//3) 5 XOR 2 = 7.
// 
//
// 示例 2： 
//
// 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
//输出：[15,-1,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, queries.length <= 105 
// queries[i].length == 2 
// 0 <= nums[j], xi, mi <= 109 
// 
// Related Topics 位运算 字典树 
// 👍 29 👎 0


//L1707、与数组中元素的最大异或值 ---- 
public class L1707_MaximumXorWithAnElementFromArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maximizeXor(int[] nums, int[][] queries) {
            return null;
        }


        public void insert(int num, TrieNode node) {

            for (int i = 31; i >= 0; i--) {
                int pos = ((num >> i) & 1);
                if (node.son[pos] == null) {
                    node.son[pos] = new TrieNode();
                }
                node = node.son[pos];
            }

        }

        //给定字典树和一个数，返回其最大异或值
        public int findMaxXorInTire(int num, TrieNode node) {
            int result = 0;
            for (int i = 31; i >= 0; i--) {
                int flag = ((num >> i) & 1) == 1 ? 0 : 1;
                if (node.son[flag] != null) {
                    result |= (1 << i);
                    node = node.son[flag];
                } else {
                    node = node.son[1 - flag];
                }
            }
            return result;
        }

        public int findMaxmunXor(int[] nums) {
            TrieNode node = new TrieNode();
            //建立字典树
            for (int num : nums) {
                insert(num, node);
            }
            int maxnum = 0;
            //遍历数组，从字典树中查找最大的异或值并记录
            for (int num : nums) {
                int m = findMaxXorInTire(num, node);
                maxnum = Math.max(maxnum, m);
            }
            return maxnum;
        }

    }

    /**
     * 树节点，每个节点有两个子节点
     *
     * @author SL
     */
    class TrieNode {

        TrieNode[] son;// TrieNode[26] in this case

        TrieNode() {
            son = new TrieNode[2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L1707_MaximumXorWithAnElementFromArray().new Solution();

    }
}