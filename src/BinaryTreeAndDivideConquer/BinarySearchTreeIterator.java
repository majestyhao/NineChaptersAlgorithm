package BinaryTreeAndDivideConquer;

import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTreeIterator {
	Queue<TreeNode> result;
	//@param root: The root of binary tree.
    public BinarySearchTreeIterator(TreeNode root) {
    	// do in-order traversal and store the result inside an array 
    	result = inOrderTraversal(root);
    }
    
    private LinkedList<TreeNode> inOrderTraversal(TreeNode node) {
    	LinkedList<TreeNode> result = new LinkedList<TreeNode>();
    	
    	if (node == null) {
    		return result;
    	}
    	
    	LinkedList<TreeNode> left = inOrderTraversal(node.left);
    	LinkedList<TreeNode> right = inOrderTraversal(node.right);
    	for (int i = 0; i < left.size(); i++) {
    		result.add(left.get(i));
    	}
    	result.add(node);
    	for (int i = 0; i < right.size(); i++) {
    		result.add(right.get(i));
    	}
    	
    	return result;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
    	if (result.isEmpty()) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    //@return: return next node
    public TreeNode next() {
    	return result.remove();
    }
}
