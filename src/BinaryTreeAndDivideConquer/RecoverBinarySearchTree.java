package BinaryTreeAndDivideConquer;

/**
 * Created by watershed2106 on 10/7/15.
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        ResultType res = inOrderCheck(root);
        if (res.bad1 == null) {
            swap(root, root.left != null? root.left: root.right);
            //System.out.println(root.val);
            return;
        }
        if (res.bad2 == null) {
            TreeNode badParent = findParent(root, res.bad1);
            swap(badParent, res.bad1);
            System.out.println(res.bad1.val);
            System.out.println(badParent.val);
            return;
        }
        swap(res.bad1, res.bad2);
        //System.out.println(res.bad1.val);
        //System.out.println(res.bad2.val);
    }

    private TreeNode findParent(TreeNode root, TreeNode bad) {
        if (root == null || root.left == bad || root.right == bad) {
            return root;
        }

        TreeNode left = findParent(root.left, bad);
        return left != null? left: findParent(root.right, bad);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    class ResultType {
        TreeNode min, max;
        TreeNode bad1, bad2;
        ResultType() {
            min = null;
            max = null;
            bad1 = null;
            bad2 = null;
        }
    }

    private ResultType inOrderCheck(TreeNode node) {
        ResultType res = new ResultType();
        if (node == null) {
            return res;
        }

        ResultType left = inOrderCheck(node.left);

        if (left.bad1 != null) {
            assign(res, left.bad1);
        }
        if (left.bad2 != null) {
            assign(res, left.bad2);
            return res;
        }
        if (left.max != null && node.val < left.max.val) {
            assign(res, left.max);
        }
        if (res.bad1 != null && res.bad2 != null) {
            return res;
        }

        ResultType right = inOrderCheck(node.right);
        if (right.bad1 != null) {
            assign(res, right.bad1);
        }
        if (right.bad2 != null) {
            assign(res, right.bad2);
            return res;
        }
        if (right.min != null && right.min.val < node.val) {
            assign(res, right.min);
        }

        if (left.min != null) {
            res.min = left.min.val < node.val? left.min: node;
        }
        if (right.min != null) {
            res.min = right.min.val < node.val? right.min: node;
        }
        if (left.min == null && right.min == null) {
            res.min = node;
        }

        if (left.max != null) {
            res.max = left.max.val < node.val? left.max: node;
        }
        if (right.max != null) {
            res.max = right.max.val < node.val? right.max: node;
        }
        if (left.max == null && right.max == null) {
            res.max = node;
        }

        return res;
    }

    private void assign(ResultType res, TreeNode node) {
        if (res.bad1 == null) {
            res.bad1 = node;
        } else if (res.bad1 == node) {
            return;
        } else if(res.bad2 == null) {
            res.bad2 = node;
        } else if(res.bad2 == node) {
            return;
        }
    }
}
