package hot100;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 769 👎 0


//L215、数组中的第K个最大元素 ---- 
public class L215_KthLargestElementInAnArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {

            bulidHeap(nums);

            for (int i = 1; i <= k; i++) {
                //把头换到尾部
                swap(nums, 0, nums.length - i);
                adjustHeap(nums, 0, nums.length - i - 1);
            }

            return nums[nums.length - k];
        }

        public void bulidHeap(int[] nums) {
            //构建最大堆
            for (int i = nums.length / 2; i >= 0; i--) {
                adjustHeap(nums, i, nums.length - 1);
            }

        }

        public void adjustHeap(int[] nums, int index, int length) {
            int parent = index;
            int child = 2 * parent + 1;
            while (child <= length) {
                if (child + 1 <= length && nums[child] < nums[child + 1]) child++;
                if (nums[parent] < nums[child]) {
                    swap(nums, parent, child);
                }
                parent = child;
                child = 2 * parent + 1;
            }
        }


        public void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L215_KthLargestElementInAnArray().new Solution();

    }
}