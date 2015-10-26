package DataStructure.SegmentTree;

/**
 * Created by hao on 15-10-26.
 */
public class SegmentTreeModify {
    /**
     *@param root, index, value: The root of segment tree and
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
       if (root.start == root.end && root.end == index) {
           root.max = value;
           return;
       }

       int mid = root.start + (root.end - root.start) / 2;
       if (mid + 1 <= index) {
           modify(root.right, index, value);
       } else {
           modify(root.left, index, value);
       }

       root.max = Math.max(root.left.max, root.right.max);
    }
}
