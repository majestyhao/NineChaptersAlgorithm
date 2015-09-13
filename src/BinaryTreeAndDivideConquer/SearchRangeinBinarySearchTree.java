package BinaryTreeAndDivideConquer;

import java.util.ArrayList;

public class SearchRangeinBinarySearchTree {
	/**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (root == null) {
    		return result;
    	}
    	
    	ArrayList<Integer> left = searchRange(root.left, k1, k2);
    	for (int i = 0; i < left.size(); i++) {
    		result.add(left.get(i));
    	}
    	
    	// ascending order == in-order for BST
    	if (root.val <= k2 && root.val >= k1) {
    		result.add(root.val);
    	}
    	
    	ArrayList<Integer> right = searchRange(root.right, k1, k2);
    	for (int i = 0; i < right.size(); i++) {
    		result.add(right.get(i));
    	}
    	
    	return result;
    }
}
