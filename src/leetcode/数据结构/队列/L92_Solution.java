package leetcode.数据结构.队列;

import common.ListNode;

/**
 * 描述:
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author luokui
 * @create 2020-06-23 17:56
 */
public class L92_Solution {


    /**
     * 反转前k个节点
     *
     * @param a
     * @param k
     * @return
     */
    ListNode reverse(ListNode a, int k) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = null;
        while (k >= 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            k--;
        }
        //新的节点连接起来
        a.next = cur;
        return pre;
    }

    /**
     * 反转从m到n的节点
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        ListNode mPre = head;
        ListNode mn = head;
        for (int i = 1; i < m; i++) {
            mPre = mn;
            mn = mn.next;
        }
        //这地方比较绕，可以优化
        if (mPre == mn) {
            head = reverse(mn, n - m);
        } else {
            mPre.next = reverse(mn, n - m);
        }
        return head;

    }
}
