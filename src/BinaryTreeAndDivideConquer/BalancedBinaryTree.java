package BinaryTreeAndDivideConquer;

public class BalancedBinaryTree {
	/**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
    	return maxDepth(root) != -1;
    }
    
    private int maxDepth(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    	
    	int left = maxDepth(node.left);
    	int right = maxDepth(node.right);
    	
    	// use -1 as indicator for unbalanced situation
    	if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
    		return -1;
    	} 
    	
    	return Math.max(left, right) + 1;
    }
	
}
