package leetcode.k;

import common.ListNode;

/**
 * @auther k
 * @date 2019/6/16 下午1:50
 * 题目：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

public class L21MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         if(null == l1 && null == l2){return null;}
        if(null == l1){return l2;}
        if(null == l2){return l1;}
        ListNode result;
        if(l1.val >= l2.val){
            result = l2;
            result.next = mergeTwoLists(l1,l2.next);
        }else{
            result = l1;
            result.next = mergeTwoLists(l1.next ,l2);
        }
       return result;
    }
}
