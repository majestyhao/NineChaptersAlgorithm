package BinaryTreeAndDivideConquer;

public class ValidateBinarySearchTree {
	/**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
	private class ResultType {
		int min, max;
		ResultType(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
	
	// store the min and the max values of the subtree rooted from node
	private ResultType isValidBSTHelper(TreeNode node) {
		if (node == null) {
			return new ResultType(Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		
		ResultType left = isValidBSTHelper(node.left);
		ResultType right = isValidBSTHelper(node.right);
		
		int min = Math.min(Math.min(left.min, right.min), node.val);
		int max = Math.max(Math.max(right.max, left.max), node.val);
		return new ResultType(min, max);
	}
	
    public boolean isValidBST(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	
    	if (!isValidBST(root.left) || !isValidBST(root.right)) {
    		return false;
    	}
    	
    	ResultType left = isValidBSTHelper(root.left);
    	ResultType right = isValidBSTHelper(root.right);
    	
    	if ((root.left == null || left.max < root.val) 
    			&& (root.right == null || right.min > root.val)) {
    		return true;
    	} else {
    		return false;
    	}
    }

}
