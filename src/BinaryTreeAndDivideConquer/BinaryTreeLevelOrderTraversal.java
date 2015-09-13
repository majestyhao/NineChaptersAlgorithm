package BinaryTreeAndDivideConquer;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {
	/**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	if (root == null) {
    		return results;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	result.add(root.val);
    	results.add(result);
    	queue.add(root);
    	Queue<Integer> levels = new LinkedList<Integer>();
    	levels.add(0);
    	result = new ArrayList<Integer>();
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.remove();
    		int level = levels.remove();
    		if (node.left != null) {
    			queue.add(node.left);
    			levels.add(level + 1);
    			result.add(node.left.val);
    		}
    		if (node.right != null) {
    			queue.add(node.right);
    			levels.add(level + 1);
    			result.add(node.right.val);
    		}
    		if (levels.isEmpty() || level != levels.peek()) {
    			if (!result.isEmpty()) {
            		results.add(result);
            	}
    			result = new ArrayList<Integer>();
    		}
    	}
    	
    	return results;
    }
}
