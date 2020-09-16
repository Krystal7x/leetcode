package leetcode.动态规划;

//堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最
//高的一堆箱子。箱堆的高度为每个箱子高度的总和。 
//
// 输入使用数组[wi, di, hi]表示每个箱子。 
//
// 示例1: 
//
//  输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
// 输出：6
// 
//
// 示例2: 
//
//  输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
// 输出：10
// 
//
// 提示: 
//
// 
// 箱子的数目不大于3000个。 
// 
// Related Topics 动态规划 回溯算法 
// 👍 22 👎 0


import java.util.Arrays;

public class interview0813_PileBoxLcci {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int pileBox(int[][] box) {
            if (box == null || box.length == 0) return 0;
            //这个排序牛逼啊
            Arrays.sort(box, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? b[2] - a[2] : b[1] - a[1] : a[0] - b[0]);

            int length = box.length;
            int[] height = new int[length];
            for (int i = 0; i < length; i++) {
                height[i] = box[i][2];
            }
            int max = height[0];
            for (int i = 1; i < length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (box[j][0] < box[i][0] && box[j][1] < box[i][1] && box[j][2] < box[i][2]) {
                        height[i] = Math.max(height[i], height[j] + box[i][2]);
                    }
                }
                max = Math.max(max, height[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new interview0813_PileBoxLcci().new Solution();

    }
}