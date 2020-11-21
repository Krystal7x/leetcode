package toppick;

//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 543 👎 0


//L69、x 的平方根 ---- 
public class L69_Sqrtx {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mySqrt(int x) {
            if (x == 0 || x == 1) return x;
            int left = 0;
            int right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int x1 = x / mid; //用来判断mid大于目标还是小于目标，或等于目标
                int x2 = x / (mid + 1);
                if (x / x1 == x1) return x1; //刚好是他的算术平方根
                if (x1 > mid && x2 < mid + 1) return mid; //例如6 在2的平方以及 3的平方之间  答案为2
                if (x1 > mid) left = mid + 1; //调整边界
                if (x1 < mid) right = mid - 1;
            }
            return 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L69_Sqrtx().new Solution();

    }
}