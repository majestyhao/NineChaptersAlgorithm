package BinaryTreeAndDivideConquer;

public class LowestCommonAncestor {
	/**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) {
			return null;
		}

		if (root == A) {
			return A;
		} else if (root == B) {
			return B;
		} else {
			TreeNode left = lowestCommonAncestor(root.left, A, B);
			TreeNode right = lowestCommonAncestor(root.right, A, B);
			if (left != null && right != null) {
				return root;
			} else if (left != null) {
				return left;
			} else if (right != null) {
				return right;
			} else {
				return null;
			}
		}
    }
}
