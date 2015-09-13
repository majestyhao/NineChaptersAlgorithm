package BinaryTreeAndDivideConquer;

import java.util.Stack;
import java.util.ArrayList;


public class PreorderTraversalNoRecursion {
	 /**
	  * @param root: The root of binary tree.
	  * @return: Preorder in ArrayList which contains node values.
	  */ 
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 
		 if (root == null) {
			 return result;
		 }
		 
		 Stack<TreeNode> stack = new Stack<TreeNode>();
		 stack.push(root);
		 while (!stack.isEmpty()) {
			 TreeNode node = stack.pop();
			 result.add(node.val);
			 // notice right goes to stack first 
			 if (node.right != null) {
				 stack.push(node.right);
			 }
			 if (node.left != null) {
				 stack.push(node.left);
			 }
		 }
		 
		 return result;
	 }
	
}
