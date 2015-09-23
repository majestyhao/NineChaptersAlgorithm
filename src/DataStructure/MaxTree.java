package DataStructure;

import java.util.Stack;
import BinaryTreeAndDivideConquer.TreeNode;

public class MaxTree {
	/**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
    	if (A.length == 0) {
    		return null; 
    	}
    	
    	int[] newA = new int[A.length + 1];
    	for (int i = 0; i < A.length; i++) {
    		newA[i] = A[i];
    	}
    	newA[newA.length - 1] = Integer.MAX_VALUE;
    	A = newA;
    	
    	// 大的进去后小的出栈做为此大的左结点或者新peek的右结点
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	for (int i = 0; i < A.length; i++) {
    		TreeNode node = new TreeNode(A[i]);
    		while (!stack.isEmpty() && A[i] > stack.peek().val) {
    			TreeNode small = stack.pop();
    			if (!stack.isEmpty() && stack.peek().val < A[i]) {
    				stack.peek().right = small;
    			} else {
    				node.left = small;
    			}
    		}
    		stack.push(node);
    	}
    	
    	return stack.pop().left;
    }
}
