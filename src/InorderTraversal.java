import java.util.ArrayList;


public class InorderTraversal {
	public class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	          this.val = val;
	          this.left = this.right = null;
	      }
	  }
	/**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<Integer>();
    	}
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	inorderTravHelper(result, root);
    	return result;
    }
    
    private void inorderTravHelper(ArrayList<Integer> result, TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	inorderTravHelper(result, node.left);
    	result.add(node.val);
    	inorderTravHelper(result, node.right);
    }
}
