package BinaryTreeAndDivideConquer;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {
	/**
	 * @param root: The root of binary tree.
	 * @return: Level order a list of lists of integer
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			// notice here
			int len = queue.size();
			ArrayList<Integer> subres = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.remove();
				if (node == null) {
					continue;
				}
				// check visited if it is a graph rather than a tree
				subres.add(node.val);
				queue.add(node.left);
				queue.add(node.right);
			}
			if (subres.size() != 0) {
				res.add(subres);
			}
		}

		return res;
	}
}
