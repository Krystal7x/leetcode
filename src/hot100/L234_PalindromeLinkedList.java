package hot100;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 754 👎 0


import common.ListNode;

//L234、回文链表 ----
public class L234_PalindromeLinkedList {

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
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;
            ListNode mid = findMid(head);
            ListNode p1 = head;
            ListNode p2 = reverse(mid.next);
            while (p1 != null && p2 != null) {
                if (p1.val != p2.val) return false;
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }

        private ListNode findMid(ListNode head) {
            ListNode fast = head.next;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode n) {
            if (n == null || n.next == null) return n;
            ListNode h = reverse(n.next);
            n.next.next = n;
            n.next = null;
            return h;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L234_PalindromeLinkedList().new Solution();

    }
}