package BinaryTreeAndDivideConquer;

import java.util.Stack;

public class BinarySearchTreeIterator {
	private Stack<TreeNode> stack = new Stack<>();
	private TreeNode curt; // current visited node

	//@param root: The root of binary tree.
	public BinarySearchTreeIterator(TreeNode root) {
		curt = root;
	}

	//@return: True if there has next node, or false
	public boolean hasNext() {
		return (curt != null || !stack.isEmpty());
	}

	//@return: return next node
	public TreeNode next() {
		// 找到最左结点
		while (curt != null) {
			stack.push(curt);
			curt = curt.left;
		}

		curt = stack.pop();
		TreeNode node = curt;
		curt = curt.right;

		return node;
	}
}
