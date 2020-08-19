package leetcode.技巧类.双指针;

import common.ListNode;

/**
 * 描述:
 * 给定一个链表，判断链表中是否有环。
 *
 * @author luokui
 * @create 2020-07-20 16:22
 */
public class L141_Solution {

    /**
     * 是否有环
     *
     * @param head
     * @return
     */
    boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
