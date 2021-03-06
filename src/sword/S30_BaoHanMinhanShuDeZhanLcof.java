package sword;

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.toppick();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 59 👎 0


import java.util.Stack;

public class S30_BaoHanMinhanShuDeZhanLcof {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        //保存最小值
        Stack<Integer> min;
        //保存真实值
        Stack<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            min = new Stack<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);

            if (min.isEmpty()) {
                min.push(x);
            } else {
                if (min.peek() > x) {
                    min.push(x);
                } else {
                    min.push(min.peek());
                }
            }

        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.toppick();
     * int param_4 = obj.min();
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {

    }
}