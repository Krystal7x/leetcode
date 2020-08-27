package leetcode.数据结构.队列;

import common.ListNode;

/**
 * 描述:删除一个节点
 *
 * @author luokui
 * @create 2020-08-27 14:26
 */
public class sword18 {

    int length = 0; // 链表长度，非必须，可不加
    ListNode head = new ListNode(0); // 哨兵节点

    /**
     * 删除指定的结点
     *
     * @param deletedListNode
     */
    public void removeSelectedListNode(ListNode deletedListNode) {
        // 如果此结点是尾结点我们还是要从头遍历到尾结点的前继结点，再将尾结点删除
        if (deletedListNode.next == null) {
            ListNode tmp = head;
            while (tmp.next != deletedListNode) {
                tmp = tmp.next;
            }
            // 找到尾结点的前继结点，把尾结点删除
            tmp.next = null;
        } else {
            //狸猫换太子

            ListNode nextListNode = deletedListNode.next;
            // 将删除结点的后继结点的值赋给被删除结点
            deletedListNode.val = nextListNode.val;
            // 将 nextListNode 结点删除
            deletedListNode.next = nextListNode.next;
            nextListNode.next = null;
        }
    }
}
