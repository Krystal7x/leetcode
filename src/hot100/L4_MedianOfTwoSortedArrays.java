package hot100;

//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3350 👎 0


public class L4_MedianOfTwoSortedArrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        /**
         * https://www.jianshu.com/p/40217a93b2e6
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length + nums2.length;
            if (n % 2 == 1)//和为奇数，返回第n/2+1个数
                return getMid(nums1, nums2, n / 2 + 1);
            if (n % 2 == 0)//和为偶数，返回第n/2个数和第n/2+1个数的和的一半
                return (getMid(nums1, nums2, n / 2) + getMid(nums1, nums2, n / 2 + 1)) / 2.0;
            else
                return 0;
        }

        public double getMid(int[] nums1, int[] nums2, int k) {
            //返回第k个数
            int start1 = 0, start2 = 0;
            while (true) {
                if (start1 == nums1.length)
                    return nums2[start2 + k - 1];
                if (start2 == nums2.length)
                    return nums1[start1 + k - 1];
                if (k == 1)
                    return Math.min(nums1[start1], nums2[start2]);
                int index1 = Math.min(start1 + k / 2 - 1, nums1.length - 1);
                int index2 = Math.min(start2 + k / 2 - 1, nums2.length - 1);
                if (nums1[index1] <= nums2[index2]) {
                    k -= index1 - start1 + 1;
                    start1 = index1 + 1;
                } else {
                    k -= index2 - start2 + 1;
                    start2 = index2 + 1;
                }
            }
        }


        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            int m = 0;
            int n = 0;
            int l1 = nums1.length;
            int l2 = nums2.length;
            int pos = (l1 + l2) / 2;
            int left = 0;
            int right = 0;
            int half = 0;
            while (m < l1 || n < l2) {
                if (half > pos) break;//找到n/2个小的了
                //记录前一个值
                left = right;
                if (m < l1 && n < l2) {
                    if (nums1[m] <= nums2[n]) {
                        right = nums1[m];
                        m++;
                    } else {
                        right = nums2[n];
                        n++;

                    }
                } else if (m < l1) {
                    right = nums1[m];
                    m++;
                } else if (n < l2) {
                    right = nums2[n];
                    n++;

                }
                half++;
            }
            //奇数的情况，此时
            if ((l1 + l2) % 2 == 1) {
                return right;
            } else {
                //偶数
                return (left + right + 0.0) / 2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L4_MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

    }
}