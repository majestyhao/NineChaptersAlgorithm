package BinaryTreeAndDivideConquer;

import java.util.ArrayList;

public class PreorderTraversalDC {
	 /**
	  * @param root: The root of binary tree.
	  * @return: Preorder in ArrayList which contains node values.
	  */ 
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 
		 if (root == null) {
			 return result;
		 }
		 
		 ArrayList<Integer> left = preorderTraversal(root.left);
		 ArrayList<Integer> right = preorderTraversal(root.right);
		 
		 result.add(root.val);
		 result.addAll(left);
		 result.addAll(right);
		 
		 return result;
	 }

}
