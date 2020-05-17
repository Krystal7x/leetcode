package leetcode.k;

import common.ListNode;

/**
 * @auther k
 * @date 2019-06-22 15:22
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

public class L2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){ return null;}
        if(l1 == null && l2 != null){ return l2;}
        if(l2 == null && l1 != null){ return l1;}
        int add = l1.val + l2.val;
        //处理进位
        if(add >= 10){
            add -= 10;
            //若下一个都不为空，则随便加一个
            if(l1.next != null && l2.next != null){
                l1.next.val += 1;
            }else if(l1.next == null){
                l1.next = new ListNode(1);
            }else if(l2.next == null){
                l2.next = new ListNode(1);
            }
        }
        ListNode n = new ListNode(add);
        n.next = addTwoNumbers(l1.next, l2.next);
        return n;
    }
}
