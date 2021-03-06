package hot100;

//设计一个支持 push ，pop ，toppick 操作，并能在常数时间内检索到最小元素的栈。
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// toppick() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","toppick","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.toppick();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、toppick 和 getMin 操作总是在 非空栈 上调用。
// 
// Related Topics 栈 设计 
// 👍 711 👎 0


import java.util.Stack;

//L155、最小栈 ----
public class L155_MinStack {

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
     * int param_4 = obj.getMin();
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {

    }
}