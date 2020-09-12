package leetcode.技巧类.概率;

import common.ListNode;

import java.util.Random;

/**
 * 描述:
 *
 * @author luokui
 * @create 2020-08-24 17:04
 */
public class L382_Solution {


    //L382_Solution

    /**
     * 当你遇到第 i 个元素时，应该有 1/i 的概率选择该元素，1 - 1/i 的概率保持原有的选择。
     * <p>
     * 第 i 个元素被选择的概率是 1/i，第 i+1 次不被替换的概率是 1 - 1/(i+1)，
     * 以此类推，分解因式，相乘就是第 i 个元素最终被选中的概率，就是 1/n。
     *
     * @param head
     * @return
     */
    int getRandom(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int ans = 0;
        int i = 0;
        Random r = new Random();
        while (cur != null) {
            if (r.nextInt(++i) == 0) {
                ans = cur.val;
            }
            cur = cur.next;
            i++;
        }
        return ans;
    }


    //398
    int[] getRandom(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;

        // 前 k 个元素先默认选上
        for (int j = 0; j < k && p != null; j++) {
            res[j] = p.val;
            p = p.next;
        }

        int i = k;
        // while 循环遍历链表
        while (p != null) {
            // 生成一个 [0, i) 之间的整数
            int j = r.nextInt(i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
            i++;
        }
        return res;
    }
}
