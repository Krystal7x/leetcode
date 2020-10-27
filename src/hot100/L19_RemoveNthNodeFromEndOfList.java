package hot100;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1085 👎 0


import common.ListNode;

//删除链表的倒数第N个节点
public class L19_RemoveNthNodeFromEndOfList {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode ans = head;
            ListNode pre = null;
            ListNode fast = head;
            ListNode slow = head;
            while (slow != null) {
                if (n > 0) {
                    slow = slow.next;
                    n--;
                } else {
                    pre = fast;
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            if (pre == null) {
                //删除头节点
                ans = head.next;
                head.next = null;
            } else {
                pre.next = pre.next.next;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L19_RemoveNthNodeFromEndOfList().new Solution();

    }
}