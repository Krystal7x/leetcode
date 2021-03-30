package leetcode.数据结构.图;

/**
 * 描述:Floyd算法求最短路径
 * https://blog.csdn.net/fengchi863/article/details/80036586
 *
 * @author luokui
 * @create 2021-03-30 5:40 PM
 */
public class Floyd {
    /**
     * floyd最短路径。
     * 即，统计图中各个顶点间的最短路径。
     * 参数说明：
     * mVexs;       // 顶点集合
     * mMatrix;    // 邻接矩阵
     * path -- 路径。path[i][j]=k表示，"顶点i"到"顶点j"的最短路径会经过顶点k。
     * dist -- 长度数组。即，dist[i][j]=sum表示，"顶点i"到"顶点j"的最短路径的长度是sum。
     */
    public void floyd(char[] mVexs, int[][] mMatrix, int[][] path, int[][] dist) {

        int max = Integer.MAX_VALUE;
        // 初始化
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++) {
                dist[i][j] = mMatrix[i][j];    // "顶点i"到"顶点j"的路径长度为"i到j的权值"。
                path[i][j] = j;                // "顶点i"到"顶点j"的最短路径是经过顶点j。
            }
        }

        // 计算最短路径
        //每个节点
        for (int k = 0; k < mVexs.length; k++) {
            //遍历矩阵
            for (int i = 0; i < mVexs.length; i++) {
                for (int j = 0; j < mVexs.length; j++) {

                    // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                    int tmp = (dist[i][k] == max || dist[k][j] == max) ? max : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp) {
                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                        dist[i][j] = tmp;
                        // "i到j最短路径"对应的路径，经过k
                        path[i][j] = path[i][k];
                    }
                }
            }
        }

        // 打印floyd最短路径的结果
        System.out.println("floyd: \n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%2d  ", dist[i][j]);
            System.out.println("\n");
        }
    }
}
