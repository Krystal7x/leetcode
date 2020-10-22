package leetcode.数据结构.栈;

//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计 
// 👍 232 👎 0


import java.util.LinkedList;
import java.util.Queue;

public class L225_ImplementStackUsingQueues {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {


        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (q2.isEmpty()) {
                q1.add(x);
            } else {
                q2.add(x);
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (!q1.isEmpty()) {
                if (q1.size() == 1) {
                    return q1.poll();
                }
                while (q1.size() > 1) {
                    q2.add(q1.poll());
                }
                return q1.poll();
            }
            if (!q2.isEmpty()) {
                if (q2.size() == 1) {
                    return q2.poll();
                }
                while (q2.size() > 1) {
                    q1.add(q2.poll());
                }
                return q2.poll();
            }
            return -1;

        }

        /**
         * Get the top element.
         */
        public int top() {

            if (!q1.isEmpty()) {
                if (q1.size() == 1) {
                    return q1.peek();
                }
                while (q1.size() > 1) {
                    q2.add(q1.poll());
                }
                int n = q1.peek();
                q2.add(q1.poll());
                return n;
            }
            if (!q2.isEmpty()) {
                if (q2.size() == 1) {
                    return q2.peek();
                }
                while (q2.size() > 1) {
                    q1.add(q2.poll());
                }
                int n = q2.peek();
                q1.add(q2.poll());
                return n;
            }
            return -1;

        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            if (q1.isEmpty() && q2.isEmpty()) {
                return true;
            }
            return false;

        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {

    }
}