import java.util.ArrayList;

public class PostorderTraversal {
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<Integer>();
    	}
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	postorderTravHelper(result, root);
    	return result;
    }
    
    private void postorderTravHelper(ArrayList<Integer> result, TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	postorderTravHelper(result, node.left);
    	postorderTravHelper(result, node.right);
    	result.add(node.val);
    }
}
