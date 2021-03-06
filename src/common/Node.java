package common;

/**
 * @auther k
 * @date 2019-07-07 12:38
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};