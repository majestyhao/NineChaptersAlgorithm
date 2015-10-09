package BinaryTreeAndDivideConquer;

import java.util.*;

/**
 * Created by watershed2106 on 10/8/15.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean left2Right = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subRes = new ArrayList<Integer>();
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (!left2Right) {
                    stack.add(node.val);
                } else {
                    subRes.add(node.val);
                }
            }

            left2Right = !left2Right;
            len = stack.size();
            for (int i = 0; i < len; i++) {
                subRes.add(stack.pop());
            }

            res.add(subRes);
        }

        return res;
    }
}
