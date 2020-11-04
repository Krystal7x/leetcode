package hot100;

//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1317 👎 0


import common.ListNode;

//L206、反转链表 ----
public class L206_ReverseLinkedList {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 迭代
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
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
         * 递归
         *
         * @param head
         * @return
         */

        public ListNode reverseList2(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode node = reverseList2(head.next);
            ListNode h = node;
            while (node.next != null) {
                node = node.next;
            }
            node.next = head;
            head.next = null;
            return h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L206_ReverseLinkedList().new Solution();

    }
}