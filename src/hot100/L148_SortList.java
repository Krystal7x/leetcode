package hot100;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 805 👎 0


import common.ListNode;

//L148、排序链表 ----
public class L148_SortList {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 归并解决链表排序
     * <p>
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
        public ListNode sortList(ListNode head) {
            // 1、递归结束条件
            if (head == null || head.next == null) {
                return head;
            }

            // 2、找到链表中间节点并断开链表 & 递归下探
            ListNode midNode = middleNode(head);
            ListNode rightHead = midNode.next;
            midNode.next = null;

            ListNode left = sortList(head);
            ListNode right = sortList(rightHead);

            // 3、当前层业务操作（合并有序链表）
            return mergeTwoLists(left, right);
        }

        //  找到链表中间节点（876. 链表的中间结点）
        private ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        // 合并两个有序链表（21. 合并两个有序链表）
        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode sentry = new ListNode(-1);
            ListNode curr = sentry;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }

                curr = curr.next;
            }

            curr.next = l1 != null ? l1 : l2;
            return sentry.next;
        }
    }

    /**
     * 快排解决链表排序
     */
    class Solution2 {
        public ListNode sortList(ListNode head) {
            //采用快速排序
            quickSort(head, null);
            return head;
        }

        public void quickSort(ListNode head, ListNode end) {
            if (head != end) {
                ListNode node = partion(head, end);
                quickSort(head, node);
                quickSort(node.next, end);
            }
        }

        public ListNode partion(ListNode head, ListNode end) {
            ListNode p1 = head, p2 = head.next;

            //走到末尾才停
            while (p2 != end) {

                //大于key值时，p1向前走一步，交换p1与p2的值
                if (p2.val < head.val) {
                    p1 = p1.next;

                    int temp = p1.val;
                    p1.val = p2.val;
                    p2.val = temp;
                }
                p2 = p2.next;
            }

            //当有序时，不交换p1和key值
            if (p1 != head) {
                int temp = p1.val;
                p1.val = head.val;
                head.val = temp;
            }
            return p1;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new L148_SortList().new Solution();

    }
}