package GraphandSearch.BFS;

import GraphandSearch.UndirectedGraphNode;

import java.util.*;

/**
 * Created by hao on 15-10-22.
 */
public class ConnectedComponentintheUndirectedGraph {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (set.contains(node)) {
                continue;
            }
            List<Integer> subRes = new ArrayList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    UndirectedGraphNode cur = queue.remove();
                    if (set.contains(cur)) {
                        continue;
                    }
                    set.add(cur);
                    subRes.add(cur.label);
                    for (UndirectedGraphNode neighbor : cur.neighbors) {
                        queue.add(neighbor);
                    }
                }
            }

            Collections.sort(subRes);
            res.add(subRes);
        }

        return res;
    }
}
