package leetcode.技巧类.双指针;

import common.ListNode;

/**
 * 描述:
 * 已知链表中含有环，返回这个环的起始位置
 *
 * @author luokui
 * @create 2020-07-20 16:28
 */
public class L142_Solution {


    /**
     * 已知链表中含有环，返回这个环的起始位置
     *
     * @param head
     * @return
     */
    ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (!hasCycle(head)) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (slow != fast) {
            return null;
        }
        ListNode ans = head;
        while (ans != slow) {
            ans = ans.next;
            slow = slow.next;
        }
        return ans;
    }

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
