package BinaryTreeAndDivideConquer;

public class BinaryTreeMaximumPathSum {
	/**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
    	int[] result = new int[1]; 
    	int[] sum = new int[1];
    	sum[0] = 0;
    	result[0] = Integer.MIN_VALUE;
    	traversal(root, sum, result);
    	return result[0];
    }
    	
    private void traversal(TreeNode node, int[] sum, int[] result) {
    	if (node == null) {
    		return;
    	}
    	
    	sum[0] += node.val;
    	
    	int[] left = new int[1];
    	int[] right = new int[1];
    	left[0] = 0;
    	right[0] = 0;
    	
    	traversal(node.left, left, result);
    	traversal(node.right, right, result);
    	
    	int tmp = node.val;
    	
    	if (left[0] > 0) {
    		tmp += left[0];
    	}
    	if (right[0] > 0) {
    		tmp += right[0];
    	}
    	
    	if (tmp > result[0]) {
    		result[0] = tmp;
    	}
    	sum[0] += Math.max(Math.max(left[0], right[0]), 0);
    	
    }
    	

}
