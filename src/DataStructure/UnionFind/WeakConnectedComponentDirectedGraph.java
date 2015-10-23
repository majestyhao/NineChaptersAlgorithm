package DataStructure.UnionFind;

import GraphandSearch.DirectedGraphNode;

import java.util.*;

/**
 * Created by hao on 15-10-23.
 */
public class WeakConnectedComponentDirectedGraph {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        Set<Integer> set = new HashSet<Integer>();
        for (DirectedGraphNode node : nodes) {
            set.add(node.label);
        }
        UnionFind uf = new UnionFind(set);

        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int element : set) {
            int ceo = uf.find(element);
            if (!map.containsKey(ceo)) {
                map.put(ceo, new ArrayList<Integer>());
            }

            List<Integer> list = map.get(ceo);
            list.add(element);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            res.add(list);
        }

        return res;
    }

    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind (Set<Integer> set) {
            for (Integer element : set) {
                father.put(element, element);
            }
        }

        int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }

            return parent;
        }

        void union(int x, int y) {
            int ceoX = find(x);
            int ceoY = find(y);
            father.put(ceoX, ceoY);
        }
    }
}
