package sword1;

import java.util.Stack;

/**
 * @auther k
 * @date 2019-06-29 17:07
 *
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 解题思路
 * 两个栈 stack1 和 stack2:
 *
 * push 动作都在 stack1 中进行，
 * pop 动作在 stack2 中进行。当 stack2 不为空时，直接 pop，当 stack2 为空时，先把 stack1 中的元素 pop 出来，push 到 stack2 中，再从 stack2 中 pop 元素。
 */

public class S7MyQueueByStack_L232 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * Initialize your data structure here.
     */
    public S7MyQueueByStack_L232() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            if (!stack2.empty()) {
                return stack2.pop();
            } else {
                return -1;
            }
        }

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.empty()) {
            return stack2.peek();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            if (!stack2.empty()) {
                return stack2.peek();
            } else {
                return -1;
            }
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if(stack1.empty()&&stack2.empty()){
            return true;
        }
        return false;
    }
}
