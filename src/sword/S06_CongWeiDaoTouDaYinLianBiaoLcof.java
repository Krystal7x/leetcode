package sword;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 64 👎 0


import common.ListNode;

public class S06_CongWeiDaoTouDaYinLianBiaoLcof {
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
        public int[] reversePrint(ListNode head) {
            if (head == null) return new int[0];
            //三指针法 反转列表
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = null;
            int count = 0;
            while (cur != null) {
                count++;
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            int[] ans = new int[count];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = pre.val;
                pre = pre.next;
            }
            return ans;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new S06_CongWeiDaoTouDaYinLianBiaoLcof().new Solution();

    }
}