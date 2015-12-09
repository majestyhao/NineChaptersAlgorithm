package BinaryTreeAndDivideConquer;

public class BinaryTreeMaximumPathSumDC {
	/**
	 * @param root: The root of binary tree.
	 * @return: An integer.
	 */
	public int maxPathSum(TreeNode root) {
		ResultType res = helper(root);
		return res.totalMax;
	}

	private ResultType helper(TreeNode node) {
		if (node == null) {
			return new ResultType(Integer.MIN_VALUE, 0);
		}

		ResultType left = helper(node.left);
		ResultType right = helper(node.right);
		int onePath = Math.max(0, Math.max(left.oneMax, right.oneMax));
		onePath += node.val;
		int totalMax = Math.max(onePath, Math.max(left.totalMax, right.totalMax));
		totalMax = Math.max(totalMax, left.oneMax + right.oneMax + node.val);

		return new ResultType(totalMax, onePath);
	}

	private class ResultType {
		int totalMax; // store max value of all possible solutions
		int oneMax; // single path for node.val + left or right or 0 that used for return to parent

		ResultType(int totalMax, int oneMax) {
			this.totalMax = totalMax;
			this.oneMax = oneMax;
		}
	}
	
}
