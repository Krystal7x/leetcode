package hot100;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache map = new LRUCache( 2 /* 缓存容量 */ );
//
//map.put(1, 1);
//map.put(2, 2);
//map.get(1);       // 返回  1
//map.put(3, 3);    // 该操作会使得关键字 2 作废
//map.get(2);       // 返回 -1 (未找到)
//map.put(4, 4);    // 该操作会使得关键字 1 作废
//map.get(1);       // 返回 -1 (未找到)
//map.get(3);       // 返回  3
//map.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 973 👎 0


import java.util.*;

//L146、LRU缓存机制 ----
public class L146_LruCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

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

        //自己处理链表
        Node head;
        Node tail;

        private void addToHead(Node newNode) {
            newNode.prev = head;
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
        }

        private void moveNodeToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void removeTailNode() {
            removeNode(tail.prev);
        }

        class Node {
            public int key, val;
            public Node next, prev;

            public Node(int k, int v) {
                this.key = k;
                this.val = v;
            }
        }


        /**
         * LFU
         * https://blog.csdn.net/weixin_42520239/article/details/114557403
         */
        public class LFUCache4 {

            //缓存了所有元素的node
            Map<Integer, Node2> map;
            //优先队列
            Queue<Node2> priorityQueue;

            //缓存cache 的容量
            int capacity;

            //当前缓存的元素个数
            int size;

            //全局自增
            int index = 0;

            //初始化
            public LFUCache4(int capacity) {
                this.capacity = capacity;
                if (capacity > 0) {
                    priorityQueue = new PriorityQueue<>(capacity);
                }
                map = new HashMap<>();
            }

            public int get(int key) {
                Node2 node = map.get(key);

                // node不存在，则返回 -1

                if (node == null) return -1;

                //每访问一次，频次和全局index都自增 1
                node.freq++;
                node.index = index++;
                // 每次都重新remove，再offer是为了让优先队列能够对当前Node重排序
                //不然的话，比较的 freq 和 index 就是不准确的

                priorityQueue.remove(node);
                priorityQueue.offer(node);

                return node.value;

            }

            public void put(int key, int value) {
                //容量0，则直接返回
                if (capacity == 0) return;
                Node2 node = map.get(key);
                //如果node存在，则更新它的value值
                if (node != null) {
                    node.value = value;
                    node.freq++;
                    node.index = index++;
                    priorityQueue.remove(node);
                    priorityQueue.offer(node);
                } else {
                    //如果cache满了，则从优先队列中取出一个元素，这个元素一定是频次最小，最久未访问过的元素
                    if (size == capacity) {
                        map.remove(priorityQueue.poll().key);
                        //取出元素后，size减 1
                        size--;
                    }

                    //否则，说明可以添加元素，于是创建一个新的node，添加到优先队列中
                    Node2 newNode = new Node2(key, value, index++);
                    priorityQueue.offer(newNode);
                    map.put(key, newNode);

                    //同时，size加 1
                    size++;

                }

            }

            //必须实现 Comparable 接口才可用于排序
            private class Node2 implements Comparable<Node2> {
                int key;
                int value;
                int freq = 1;
                int index;

                public Node2() {
                }

                public Node2(int key, int value, int index) {
                    this.key = key;
                    this.value = value;
                    this.index = index;

                }

                @Override
                public int compareTo(Node2 o) {
                    //优先比较频次 freq，频次相同再比较index
                    int minus = this.freq - o.freq;
                    return minus == 0 ? this.index - o.index : minus;

                }
            }

        }


    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {

    }
}