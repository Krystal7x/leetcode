package leetcode.k;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther k
 * @date 2019-06-29 17:21
 *
 * 题目描述
 * 用两个队列来实现一个栈，完成栈的Push和Pop操作。 栈中的元素为int类型。
 *
 * 解题思路
 * 两个栈 Queue1 和 Queue2:
 *
 *
 */

public class L225MyStackByQueue {

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /** Initialize your data structure here. */
    public L225MyStackByQueue() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(q2.isEmpty()){
            q1.add(x);
        }else{
            q2.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!q1.isEmpty()) {
            if (q1.size() == 1) {
                return q1.poll();
            }
            while(q1.size()>1){
                q2.add(q1.poll());
            }
            return q1.poll();
        }
        if(!q2.isEmpty()) {
            if (q2.size() == 1) {
                return q2.poll();
            }
            while(q2.size()>1){
                q1.add(q2.poll());
            }
            return q2.poll();
        }
        return -1;

    }

    /** Get the top element. */
    public int top() {

        if(!q1.isEmpty()) {
            if (q1.size() == 1) {
                return q1.peek();
            }
            while(q1.size()>1){
                q2.add(q1.poll());
            }
            int n = q1.peek();
            q2.add(q1.poll());
            return n;
        }
        if(!q2.isEmpty()) {
            if (q2.size() == 1) {
                return q2.peek();
            }
            while(q2.size()>1){
                q1.add(q2.poll());
            }
            int n = q2.peek();
            q1.add(q2.poll());
            return n;
        }
        return -1;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.isEmpty()&&q2.isEmpty()){
            return true;
        }
        return false;

    }
}
