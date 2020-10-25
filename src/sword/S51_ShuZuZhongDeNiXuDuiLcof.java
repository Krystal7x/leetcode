package sword;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 258 👎 0


public class S51_ShuZuZhongDeNiXuDuiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {
            int len = nums.length;
            if (len < 2) return 0;
            int[] copy = new int[len];
            for (int i = 0; i < len; i++) copy[i] = nums[i];
            int[] tmp = new int[len];
            return reversePairs(copy, 0, len - 1, tmp);
        }

        private int reversePairs(int[] nums, int left, int right, int[] tmp) {
            if (left == right) return 0;
            int mid = left + (right - left) / 2;
            int leftPairs = reversePairs(nums, left, mid, tmp);
            int rightPairs = reversePairs(nums, mid + 1, right, tmp);

            // 此时，左边子数组的最大数小于右边子数组的最小数，直接合并即可，不会产生逆序对
            if (nums[mid] <= nums[mid + 1]) return leftPairs + rightPairs;
            //crossPairs是将两个有序子数组归并为一个有序数组产生的逆序对
            int crossPairs = mergerAndCount(nums, left, mid, right, tmp);

            return crossPairs + rightPairs + leftPairs;
        }

        private int mergerAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
            //全程采用一个数组tmp的原因有二：不必一直创建新的数组，节约资源；每次处理的都是子数组，如果创建新的数组会导致索引的处理很麻烦，容易出错
            for (int i = left; i <= right; i++) tmp[i] = nums[i];
            int i = left;   //左边的有序数组的左边界
            int j = mid + 1;//右边的有序数组的左边界
            int count = 0;
            for (int k = left; k <= right; k++) {
                //左边走完了
                if (i == mid + 1) {
                    nums[k] = tmp[j];
                    j++;
                    continue;
                }
                //右边走完了
                if (j == right + 1) {
                    nums[k] = tmp[i];
                    i++;
                    continue;
                }
                //左边子数组的值较小，进入有序数组
                if (tmp[i] <= tmp[j]) {
                    nums[k] = tmp[i];
                    i++;
                } else {
                    //此时，右边子数组的值较小，进入有序数组
                    nums[k] = tmp[j];
                    j++;
                    count += (mid - i + 1);//左边子数组剩余的个数即为逆序对个数
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S51_ShuZuZhongDeNiXuDuiLcof().new Solution();

    }
}