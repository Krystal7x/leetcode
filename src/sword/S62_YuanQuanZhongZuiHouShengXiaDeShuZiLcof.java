package sword;

//0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// 👍 236 👎 0


public class S62_YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力-复杂度为O(mn)
         * 超时
         *
         * @param n
         * @param m
         * @return
         */
        public int lastRemaining2(int n, int m) {

            int[] circle = new int[n];
            for (int i = 0; i < n; i++) {
                circle[i] = i;
            }
            int pos = 0;
            int reduce = 0;
            int ans = -1;
            while (true) {
                int isNotDelete = 0;
                while (true) {
                    if (circle[pos] != -1) {
                        isNotDelete++;
                        if (isNotDelete == m) break;
                        pos++;
                        pos = pos % n;
                    } else {
                        pos++;
                        pos = pos % n;
                    }
                }
                ans = circle[pos];
                circle[pos] = -1;
                reduce++;
                if (reduce == n) break;

            }
            return ans;
        }

        /**
         * 数学归纳
         *
         * @param n
         * @param m
         * @return
         */
        public int lastRemaining(int n, int m) {
            int result = 0;
            for (int i = 2; i <= n; ++i) {
                result = (result + m) % i;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S62_YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();

    }
}