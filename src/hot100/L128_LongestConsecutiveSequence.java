package hot100;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 并查集 数组 
// 👍 594 👎 0


import java.util.*;

//L128、最长连续序列   -----
public class L128_LongestConsecutiveSequence {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 排序
         *
         * @param nums
         * @return
         */
        public int longestConsecutive1(int[] nums) {
            if (nums.length == 0) return 0;

            Arrays.sort(nums);

            // max 最终结果, curr 当前长度, last 上个数字
            int max = 1, curr = 1, last = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == last) continue;
                if (nums[i] == last + 1) curr++; // 符合连续，长度 +1
                else {
                    max = Math.max(max, curr); // 连不上了，记录长度
                    curr = 1; // 重新开始
                }
                last = nums[i];
            }
            max = Math.max(max, curr); // 别忘了最后一段的连续区间
            return max;
        }


        /**
         * 集合set
         *
         * @param nums
         * @return
         */
        public int longestConsecutive2(int[] nums) {
            if (nums.length == 0) return 0;

            int n = nums.length, max = 1;
            Set<Integer> set = new HashSet<>();
            for (int v : nums) set.add(v);

            for (int v : nums) {
                // 技巧：如果有比自己小一点的，那自己不查，让小的去查
                if (set.contains(v - 1)) continue;

                int r = v; // r: right 表示「以 v 开头，能连续到多少」
                while (set.contains(r + 1)) r++; // 逐个查看
                max = Math.max(max, r - v + 1); // 记录区间 [v, r] 长度
            }
            return max;
        }

        /**
         * 集合hash
         *
         * @param nums
         * @return
         */
        public int longestConsecutive3(int[] nums) {
            if (nums.length == 0) return 0;

            Map<Integer, Integer> map = new HashMap<>(); // 记录区间 [v, r]
            for (int v : nums) map.put(v, v);

            int max = 1;
            for (int v : nums) {
                int r = v;
                while (map.containsKey(r + 1))
                    r = map.get(r + 1); // 利用前面已知的右边界，快速找到当前需要的右边界
                map.put(v, r);
                max = Math.max(max, r - v + 1);
            }
            return max;
        }

        /**
         * 查并集
         *
         * @param nums
         * @return
         */
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;

            // 首次遍历，与邻居结盟
            UnionFind uf = new UnionFind(nums);
            for (int v : nums)
                uf.union(v, v + 1); // uf.union() 结盟

            // 二次遍历，记录领队距离
            int max = 1;
            for (int v : nums)
                max = Math.max(max, uf.find(v) - v + 1); // uf.find() 查找领队
            return max;
        }

        class UnionFind {
            private int count;
            private Map<Integer, Integer> parent; // (curr, leader)

            UnionFind(int[] arr) {
                count = arr.length;
                parent = new HashMap<>();
                for (int v : arr)
                    parent.put(v, v); // 初始时，各自为战，自己是自己的领队
            }

            // 结盟
            void union(int p, int q) {
                // 不只是 p 与 q 结盟，而是整个 p 所在队伍 与 q 所在队伍结盟
                // 结盟需各领队出面，而不是小弟出面
                Integer rootP = find(p), rootQ = find(q);
                if (rootP.equals(rootQ)) return;
                if (rootP == null || rootQ == null) return;

                // 结盟
                parent.put(rootP, rootQ); // 谁大听谁
                // 应取 max，而本题已明确 p < q 才可这么写
                // 当前写法有损封装性，算法题可不纠结

                count--;
            }

            // 查找领队
            Integer find(int p) {
                if (!parent.containsKey(p))
                    return null;

                // 递归向上找领队
                int root = p;
                while (root != parent.get(root))
                    root = parent.get(root);

                // 路径压缩：扁平化管理，避免日后找领队层级过深
                while (p != parent.get(p)) {
                    int curr = p;
                    p = parent.get(p);
                    parent.put(curr, root);
                }

                return root;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L128_LongestConsecutiveSequence().new Solution();

    }
}