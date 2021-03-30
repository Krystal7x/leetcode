package leetcode.数据结构.图;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 描述:
 * 判断是不是一棵树
 *
 *
 * @author luokui
 * @create 2021-03-30 6:13 PM
 */
public class ValidTree {
    /**
     * 广度遍历 ，判断是不是一棵树
     *
     * @param n     节点数
     * @param edges 保存的边
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        //保存图：使用A -（B，C）
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //邻接表保存的图
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                Set<Integer> pairs = graph.get(edges[i][j]);
                if (pairs == null) {
                    pairs = new HashSet<>();
                    graph.put(edges[i][j], pairs);
                }
                pairs.add(edges[i][1 - j]);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        //加入第一个节点

        //不一定要从根节点出发！！！！
        //目前已访问的节点
        visited.add(0);
        //目前需要访问的节点
        current.add(0);

        while (!current.isEmpty()) {

            Set<Integer> next = new HashSet<>();
            for (Integer node : current) {
                //此节点可联通的节点list
                Set<Integer> pairs = graph.get(node);
                if (pairs == null) continue;
                for (Integer pair : pairs) {
                    //此节点已访问说明有回路
                    if (visited.contains(pair)) return false;

                    next.add(pair);
                    visited.add(pair);
                    //1到2了，所以把2到1的删除
                    graph.get(pair).remove(node);
                }
            }
            current = next;
        }
        return visited.size() == n;
    }
}
