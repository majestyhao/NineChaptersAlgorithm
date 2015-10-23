package GraphandSearch.BFS;

import GraphandSearch.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
	/**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode entry) {
    	if (entry == null) {
    		return null;
    	}
    	
    	ArrayList<UndirectedGraphNode> queue = new ArrayList<UndirectedGraphNode>();
    	HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	HashMap<UndirectedGraphNode, Integer> met = new HashMap<UndirectedGraphNode, Integer>(); // to handle self-loop 
    	
    	queue.add(entry);
    	map.put(entry, new UndirectedGraphNode(entry.label));
    	
    	while (queue.size() != 0) {
    		UndirectedGraphNode node = queue.remove(0);
    		if (met.containsKey(node)) {
    			continue;
    		}
    		met.put(node, 0);
    		UndirectedGraphNode cloned = map.get(node);
    		for (int i = 0; i < node.neighbors.size(); i++) {
    			queue.add(node.neighbors.get(i));
    			UndirectedGraphNode clonedNeighbor = null;
    			if (map.containsKey(node.neighbors.get(i))) {
    				clonedNeighbor = map.get(node.neighbors.get(i));
    			} else {
    				clonedNeighbor = new UndirectedGraphNode(node.neighbors.get(i).label);
    				map.put(node.neighbors.get(i), clonedNeighbor);
    			}
    			cloned.neighbors.add(clonedNeighbor);
    		}
    	}
    	
    	return map.get(entry);
    }

}
