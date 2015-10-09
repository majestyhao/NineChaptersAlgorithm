package BinaryTreeAndDivideConquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by watershed2106 on 10/8/15.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subRes = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                subRes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(subRes);
        }

        for (int i = 0, j = res.size() - 1; i < j; i++, j--) {
            List<Integer> tmp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, tmp);
        }

        return res;
    }
}
