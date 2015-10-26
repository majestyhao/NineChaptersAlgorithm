package DataStructure.SegmentTree;

/**
 * Created by hao on 15-10-26.
 */
public class SegmentTreeQueryII {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end || root == null) {
            return 0;
        }
        if (start <= root.start && root.end <= end) {
            return root.count;
        }

        int mid = root.start + (root.end - root.start) / 2;
        int leftCount = 0, rightCount = 0;
        if (start <= mid) {
            if (mid < end) {
                leftCount = query(root.left, start, mid);
            } else {
                leftCount = query(root.left, start, end);
            }
        }
        if (mid < end) {
            if (start <= mid) {
                rightCount = query(root.right, mid + 1, end);
            } else {
                rightCount = query(root.right, start, end);
            }
        }

        return leftCount + rightCount;
    }

    public class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
}
