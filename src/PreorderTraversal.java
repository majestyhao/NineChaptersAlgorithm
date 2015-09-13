import java.util.ArrayList;


public class PreorderTraversal {
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<Integer>();
    	}
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	preorderTravHelper(result, root);
    	return result;
    }
    
    private void preorderTravHelper(ArrayList<Integer> result, TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	result.add(node.val);
    	preorderTravHelper(result, node.left);
    	preorderTravHelper(result, node.right);
    }
}
