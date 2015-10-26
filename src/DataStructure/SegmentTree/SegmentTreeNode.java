package DataStructure.SegmentTree;

/**
 * Created by hao on 15-10-26.
 */
public class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start; this.end = end;
        this.left = this.right = null;
    }
}
