package hot100;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 561 👎 0


import java.util.HashMap;
import java.util.PriorityQueue;

//L347、前 K 个高频元素 ----
public class L347_TopKFrequentElements {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            //最大堆
            PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
            for (int n : map.keySet()) {
                heap.add(new Node(n, map.get(n)));
            }
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = heap.poll().num;
            }
            return ans;
        }

        class Node {
            public int num;
            public int count;

            Node(int num, int count) {
                this.num = num;
                this.count = count;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L347_TopKFrequentElements().new Solution();

    }
}