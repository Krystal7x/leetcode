package leetcode.数据结构.图;

/**
 * 描述:最短路径Dijkstra算法
 * https://blog.csdn.net/qq_38410730/article/details/79587768
 *
 * @author luokui
 * @create 2021-03-30 5:21 PM
 */
public class Dijkstra {

    public int[] dijkstra(int[][] edges, int v) {

        int numOfVexs = edges.length;
        boolean[] st = new boolean[numOfVexs];// 默认初始为false
        int[] distance = new int[numOfVexs];// 存放源点到其他点的矩离

        for (int i = 0; i < numOfVexs; i++)
            for (int j = i + 1; j < numOfVexs; j++) {
                if (edges[i][j] == 0) {
                    edges[i][j] = Integer.MAX_VALUE;
                    edges[j][i] = Integer.MAX_VALUE;
                }
            }
        //节点v 到 i 的距离
        for (int i = 0; i < numOfVexs; i++) {
            distance[i] = edges[v][i];
        }
        st[v] = true;
        // 处理从源点到其余顶点的最短路径
        for (int i = 0; i < numOfVexs; i++) {

            // 比较从源点到其余顶点的路径长度
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < numOfVexs; ++j) {
                // 从源点到j顶点的最短路径还没有找到
                if (st[j] == false) {
                    // 从源点到j顶点的路径长度最小
                    if (distance[j] < min) {
                        index = j;
                        min = distance[j];
                    }
                }
            }

            //找到源点到索引为index顶点的最短路径长度
            if (index != -1)
                st[index] = true;
            // 更新当前最短路径及距离
            for (int w = 0; w < numOfVexs; w++)
                if (st[w] == false) {
                    if (edges[index][w] != Integer.MAX_VALUE
                            && (min + edges[index][w] < distance[w]))
                        distance[w] = min + edges[index][w];
                }
        }
        return distance;
    }


}
