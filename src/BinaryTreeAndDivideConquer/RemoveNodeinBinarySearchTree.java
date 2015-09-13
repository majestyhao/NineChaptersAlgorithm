package BinaryTreeAndDivideConquer;

public class RemoveNodeinBinarySearchTree {
	/**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
		// put the "next" node (the one at the left most of the right subtree)
		// at the empty spot
		if (root == null) {
			return null;
		}

		if (root.val < value) {
			root.right = removeNode(root.right, value);
		} else if (root.val > value) {
			root.left = removeNode(root.left, value);
		} else {
			if (root.right == null) {
				root = root.left;
			} else if (root.left == null) {
				root = root.right;
			} else {
				TreeNode node = root.right;
				while (node.left.left != null) {
					node = node.left;
				}
				if (node.left != null) {
					root.val = node.left.val;
				} else {
					root = node;
				}
				node.left = null;
			}
		}

		return root;
	}

}
