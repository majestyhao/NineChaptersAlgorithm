package BinaryTreeAndDivideConquer;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by watershed2106 on 10/7/15.
 */
public class RecoverBinarySearchTree {
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        List<TreeNode> res = inOrderChecking(root);
        swap(res.get(0), res.get(res.size() - 1));
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    private List<TreeNode> inOrderChecking(TreeNode node) {
        List<TreeNode> res = new ArrayList<TreeNode>();

        if (node == null) {
            return res;
        }

        List<TreeNode> left = inOrderChecking(node.left);
        res.addAll(left);
        if (prev != null && node.val < prev.val) {
            res.add(prev);
            res.add(node);
        }

        prev = node;
        List<TreeNode> right = inOrderChecking(node.right);
        res.addAll(right);

        return res;
    }
}
