package leetcode.数据结构.队列;

import common.ListNode;

/**
 * 描述:
 *
 * @author luokui
 * @create 2020-08-23 17:15
 */
public class L25_Solution {

    /**
     * 递归反转列表 206
     *
     * @param head
     * @return
     */
    ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return n;
    }


    /**
     * 反转列表
     *
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 「反转以 a 为头结点的链表」其实就是「反转 a 到 null 之间的结点」，
     * 那么如果让你「反转 a 到 b 之间的结点」
     *
     * @param a
     * @param b
     * @return
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = null;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //新的节点连接起来
        //a.next = b;
        return pre;
    }


    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            //最后一段不翻了
            if (b == null) {
                return a;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;


    }

}
