package leetcode.数据结构.图;

/**
 * 描述:图的联通性判断
 *
 * @author luokui
 * @create 2020-08-26 15:06
 */
class UF {

    int[] parent;
    int count;

    public UF(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

    }

    /* 将 p 和 q 连接 */
    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        //一个节点挂到另一节点上
        parent[rootp] = rootq;
        count--;
        return;
    }

    public int find(int x) {
        while (x != parent[x]) {
            //压缩路径，这样高度就不会超过3
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return parent[x];
    }

    /* 判断 p 和 q 是否连通 */
    public boolean connected(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        return rootp == rootq;
    }

    /* 返回图中有多少个连通分量 */
    public int count() {
        return count;
    }
}
