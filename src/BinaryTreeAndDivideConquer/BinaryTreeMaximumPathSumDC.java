package BinaryTreeAndDivideConquer;

public class BinaryTreeMaximumPathSumDC {
	private class ResultType {
		// max to store max value of all possible solutions
		// single path for node.val + left or right or 0 that used for return to parent
		int max, singlePath;
		
		ResultType(int singlePath, int max) {
			this.max = max;
			this.singlePath = singlePath;
		}
	}
	
	public int maxPathSum(TreeNode root) {
		ResultType result = maxPathSumHelper(root);
		return result.max;
	}
		
	private ResultType maxPathSumHelper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		
		ResultType left = maxPathSumHelper(root.left);
		ResultType right = maxPathSumHelper(root.right);
		
		int tmp = root.val;
    	
    	if (left.singlePath > 0) {
    		tmp += left.singlePath;
    	}
    	if (right.singlePath > 0) {
    		tmp += right.singlePath;
    	}
    	
    	int max = Math.max(left.max, right.max);
    	
    	if (tmp > max) {
    		max = tmp;
    	}
		
		int singlePath = root.val;
		singlePath += Math.max(Math.max(left.singlePath, right.singlePath), 0);
		
		return new ResultType(singlePath, max);
	}
	
}
