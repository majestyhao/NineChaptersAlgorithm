package BinaryTreeAndDivideConquer;

/**
 * Created by watershed2106 on 10/8/15.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int startPre,
                                     int endPre, int[] inorder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);
        int rootIndex = -1;
        for (int i = startIn; i<= endIn; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }

        root.left = buildTreeHelper(preorder, startPre + 1, startPre + (rootIndex - startIn),
                inorder, startIn, rootIndex - 1);
        root.right = buildTreeHelper(preorder, startPre + (rootIndex - startIn) + 1,
                endPre, inorder, rootIndex + 1, endIn);

        return root;
    }
}
