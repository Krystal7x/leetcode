package sword;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 150 👎 0


public class S40_ZuiXiaoDeKgeShuLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 堆排序
         * 最小堆
         *
         * @param arr
         * @return
         */
        public int[] buildHeap(int[] arr) {
            int last = arr.length - 1;
            for (int i = last / 2; i >= 0; i--) {
                adjustHeap(arr, i, last);
            }

            for (int i = last; i >= 0; i--) {
                int tmp = arr[i];
                arr[i] = arr[0];
                arr[0] = tmp;
                adjustHeap(arr, 0, i - 1);
            }
            return arr;

        }

        private void adjustHeap(int[] arr, int index, int last) {
            int parent = index;
            int child = parent * 2 + 1;
            while (child <= last) {
                //选择左右一个小的节点
                if (child + 1 <= last && arr[child] > arr[child + 1]) child++;
                if (arr[parent] > arr[child]) {
                    //交换
                    int tmp = arr[parent];
                    arr[parent] = arr[child];
                    arr[child] = tmp;

                    parent = child;
                    child = parent * 2 + 1;
                } else {
                    break;
                }
            }
        }


        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr.length == 0 || k == 0) return new int[0];
            int[] ans = new int[k];
            //生成最小堆
            int last = arr.length - 1;
            for (int i = last / 2; i >= 0; i--) {
                adjustHeap(arr, i, last);
            }

            for (int i = last, j = 0; i >= 0; i--) {
                int tmp = arr[i];
                arr[i] = arr[0];
                arr[0] = tmp;
                ans[j++] = arr[i];
                if (j >= k) break;
                adjustHeap(arr, 0, i - 1);
            }
            return ans;
        }
    }

    /**
     * 快排解决TOP-K问题
     */
    public static class TOPK {
        static int quickSortForTopK(int[] m, int n, int left, int right) {

            int index = partition(m, left, right);
            int pivot = index + 1;
            if (pivot == n) return m[index];
            return pivot > n ? quickSortForTopK(m, n, left, index - 1) : quickSortForTopK(m, n, index + 1, right);

        }

        private static int partition(int[] m, int left, int right) {
            int sign = m[left];
            int i = left + 1;
            int j = right;
            while (true) {
                while (i <= right && m[i] < sign) i++;
                while (j >= left && m[j] > sign) j--;
                if (i >= j) break;
                swap(m, i, j);
            }
            swap(m, left, j);
            return j;
        }

        private static void swap(int[] m, int i, int j) {
            int tmp = m[i];
            m[i] = m[j];
            m[j] = tmp;
        }

        public static void main(String[] args) {
            int i = quickSortForTopK(new int[]{2, 3, 4, 7, 6, 1, 5, 0}, 1, 0, 7);
            System.out.println(i);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S40_ZuiXiaoDeKgeShuLcof().new Solution();
        int[] arr = solution.getLeastNumbers(new int[]{3, 1, 5, 7, 2, 4, 9, 6, 10, 8}, 3);
        System.out.println(arr);

    }
}