package BinaryTreeAndDivideConquer;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by watershed2106 on 10/7/15.
 */
public class RecoverBinarySearchTreeTest {
    RecoverBinarySearchTree recoverBinarySearchTree;

    @Before
    public void setUp() throws Exception {
        recoverBinarySearchTree = new RecoverBinarySearchTree();
    }

    @Test
    public void testRecoverTree() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        root.right = node1;
        node1.right = node2;
        recoverBinarySearchTree.recoverTree(root);
    }
}
