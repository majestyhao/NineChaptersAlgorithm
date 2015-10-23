package GraphandSearch.BFS;

import GraphandSearch.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {
	/**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    	ArrayList<DirectedGraphNode> topSortList = new ArrayList<DirectedGraphNode>();
    	HashMap<DirectedGraphNode, Integer> inDegree = new HashMap<DirectedGraphNode, Integer>();
    	// calculate init in-degree
    	for (DirectedGraphNode node : graph) {
    		for (DirectedGraphNode neighbor : node.neighbors) {
    			if (inDegree.containsKey(neighbor)) {
    				inDegree.put(neighbor, inDegree.get(neighbor) + 1);
    			} else {
    				inDegree.put(neighbor, 1);
    			}
    		}
    	}
    	
    	// init queue with node has no incomming edges
    	Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
    	for (DirectedGraphNode node : graph) {
    		if (!inDegree.containsKey(node)) {
    			queue.add(node);
    		}
    	}
    	
    	// top sort
    	while (!queue.isEmpty()) {
    		DirectedGraphNode node = queue.poll();
    		topSortList.add(node);
    		for (DirectedGraphNode neighbor : node.neighbors) {
    			int newInDegree = inDegree.get(neighbor) - 1;
    			inDegree.put(neighbor, newInDegree);
    			if (newInDegree == 0) {
    				queue.add(neighbor);
    			}
    		}
    	}
    	
    	return topSortList;
    }

}
