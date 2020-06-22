package leetcode.数据结构;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * L146. LRU缓存机制
 *
 * @author luokui
 * @create 2020-06-21 18:09
 */
public class LRUCache {
    int capacity;
    //保存的是node
    private Map<Integer, Node> map;
    private LinkedList<Node> list;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        //双向列表
        list = new LinkedList<>();

    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node n = map.get(key);
            put(key, n.val);
            return n.val;
        }

    }

    public void put(int key, int value) {
        Node n = new Node(key, value);
        if (map.containsKey(key)) {
            //更新list
            list.remove(map.get(key));
            list.addFirst(n);
            //更新map
            map.put(key, n);

        } else {
            if (map.size() == capacity) {

                Node last = list.removeLast();
                map.remove(last.key);
            }
            list.addFirst(n);
            map.put(key, n);
        }

    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

}
