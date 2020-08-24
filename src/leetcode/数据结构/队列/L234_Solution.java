package leetcode.数据结构.队列;

import common.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * @author luokui
 * @create 2020-06-23 15:49
 */
public class L234_Solution {

    /**
     * 还有一种方法，直接反转列表，然后比较
     *
     * @param head
     * @return
     */
    ListNode left;

    boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode head) {
        if (head == null) return true;
        boolean res = traverse(head.next) && (head.val == left.val);
        left = left.next;
        return res;

    }
}
