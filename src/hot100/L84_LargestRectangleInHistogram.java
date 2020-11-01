package hot100;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 982 👎 0


import java.util.Stack;

//L84、柱状图中最大的矩形 ----
public class L84_LargestRectangleInHistogram {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 此题的本质是找到每个柱形条左边和右边最近的比自己低的矩形条，
         * 然后用宽度乘上当前柱形条的高度作为备选答案。
         *
         * @param heights
         * @return
         */
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;
            Stack<Integer> stack = new Stack<Integer>();
            int minHeight = 0;
            stack.push(-1);
            // 最左边界
            for (int i = 0; i < heights.length; i++) {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                    //栈顶
                    int tp = stack.pop();
                    //栈顶高度
                    int tpH = heights[tp];
                    //因为栈里是递增的，所以前面没有元素比tpH高了，此时计算宽度
                    //(stack.peek())是前一个比tpH小的的元素，i 是后一个比tpH小的数。因为i导致的出栈
                    int tpW = (i - 1 - stack.peek());

                    maxArea = Math.max(maxArea, tpH * tpW);
                }
                //栈里单调不递减
                stack.push(i);
            }
            //比较剩下stack栈中，包含栈中下标柱状图中最大的矩形面积；
            while (stack.peek() != -1) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
            }
            return maxArea;
        }


        public int largestRectangleArea2(int[] heights) {
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            int p = 0;
            while (p < heights.length) {
                //栈空入栈
                if (stack.isEmpty()) {
                    stack.push(p);
                    p++;
                } else {
                    int top = stack.peek();
                    //当前高度大于栈顶，入栈
                    if (heights[p] >= heights[top]) {
                        stack.push(p);
                        p++;
                    } else {
                        //保存栈顶高度
                        int height = heights[stack.pop()];
                        //左边第一个小于当前柱子的下标
                        int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                        //右边第一个小于当前柱子的下标
                        int RightLessMin = p;
                        //计算面积
                        int area = (RightLessMin - leftLessMin - 1) * height;
                        maxArea = Math.max(area, maxArea);
                    }
                }
            }
            while (!stack.isEmpty()) {
                //保存栈顶高度
                int height = heights[stack.pop()];
                //左边第一个小于当前柱子的下标
                int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
                int RightLessMin = heights.length;
                int area = (RightLessMin - leftLessMin - 1) * height;
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L84_LargestRectangleInHistogram().new Solution();

    }
}