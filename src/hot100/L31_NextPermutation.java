package hot100;

//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 709 👎 0


//L31、下一个排列
public class L31_NextPermutation {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length < 2) return;

            int index = -1;
            //找到升序的队列的需要交换的位置
            for (int i = 0; i < nums.length - 1; i++) {
                //升序
                if (nums[i] < nums[i + 1]) {
                    index = i;
                }
            }
            //没有升序就直接反过来
            if (index == -1) {
                sort(nums, 0, nums.length - 1);
                return;
            }

            //找到index后最小的数字
            int swapMinIndex = index + 1;
            for (int i = index + 2; i < nums.length - 1; i++) {
                //升序
                if (nums[i] < nums[swapMinIndex] && nums[i] > nums[index]) {
                    swapMinIndex = i;
                }
            }
            //交换这两个数字，然后升序后面的数组
            swap(nums, index, swapMinIndex);

            //index之后的数字按升序排列
            sort(nums, index + 1, nums.length - 1);

        }

        void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }

        void sort(int[] nums, int left, int right) {
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    if (nums[i] > nums[j]) {
                        swap(nums, i, j);
                    }

                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L31_NextPermutation().new Solution();
        solution.nextPermutation(new int[]{1, 3, 2});

    }
}