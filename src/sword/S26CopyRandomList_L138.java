package sword;

import common.Node;

/**
 * @auther k
 * @date 2019-07-07 12:41
 * <p>
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 解题思路
 */

public class S26CopyRandomList_L138 {

    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }
        //复制节点插入到连表中
        Node n1 = head;
        while (n1 != null) {
            Node copy = new Node(n1.val, n1.next, n1.random);
            copy.next = n1.next;
            n1.next = copy;
            n1 = copy.next;
        }
        //复制随机指针
        Node n2 = head;
        while (n2 != null) {
            Node copy = n2.next;
            copy.random = n2.random == null ? null : n2.random.next;
            n2 = copy.next;
        }
        //折分
        Node n3 = head;
        Node res = n3.next;
        while (n3 != null) {
            Node node = n3.next;
            n3.next = node.next;
            node.next = node.next == null ? null : node.next.next;
            n3 = n3.next;
        }
        return res;
    }
}
