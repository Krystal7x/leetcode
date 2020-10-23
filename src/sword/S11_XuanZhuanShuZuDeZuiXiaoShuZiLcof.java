package sword;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 167 👎 0


public class S11_XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 二分查找
         *
         * @param numbers
         * @return
         */
        public int minArray(int[] numbers) {
            if (numbers.length == 0) return -1;
            int left = 0;
            int right = numbers.length - 1;
            int res = numbers[left];
            while (numbers[left] >= numbers[right]) {
                if (left == right - 1) {
                    res = numbers[right];
                    break;
                }
                int mid = (left + right) / 2;
                if (numbers[left] == numbers[mid] && numbers[mid] == numbers[right]) {
                    //特殊情况，只能顺寻找
                    return GetMinInOrder(numbers, left, right);
                }
                if (numbers[mid] >= numbers[left]) {
                    left = mid;
                    continue;
                }
                if (numbers[mid] <= numbers[right]) {
                    right = mid;
                    continue;
                }

            }
            return res;
        }

        public int GetMinInOrder(int[] numbers, int index1, int index2) {
            int result = numbers[index1];
            for (int i = index1 + 1; i <= index2; ++i) {
                if (result > numbers[i]) {
                    result = numbers[i];
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S11_XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();

    }
}