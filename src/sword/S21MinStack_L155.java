package sword;

import java.util.Stack;

/**
 * @auther k
 * @date 2019-07-06 16:20
 * <p>
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * <p>
 * 解题思路
 * 用一个栈stack保存数据，用另外一个栈temp保存依次入栈最小的数
 * 比如，stack中依次入栈
 * 5, 3, 4, 10, 2, 12, 1, 8
 * 则temp依次入栈
 * 5, 3, 3，3, 2, 2, 1, 1
 * <p>
 * 每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则用最小元素入栈。
 */

public class S21MinStack_L155 {

    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
        s.push(x);
        if (min.isEmpty()) {
            min.push(x);
            return;
        }
        int tmp = min.peek();
        if (x < tmp) {
            min.push(x);
        } else {
            min.push(tmp);
        }

    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
