package DataStructure.SegmentTree;

/**
 * Created by hao on 15-10-26.
 */
public class SegmentTreeQuery {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // 恰好
        if (start == root.start && end == root.end) {
            return root.max;
        }

        int mid = root.start + (root.end - root.start) / 2;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        // 与左孩子相交
        if (start <= mid) {
            // 分裂: 区间只与左孩子部分相交, 只取与左孩子相交的那部分
            if (mid < end) {
                leftMax = query(root.left, start, mid);
            } else {
                leftMax = query(root.left, start, end);
            }
        }
        // 与右孩子相交
        if (mid < end) {
            // 分裂
            if (start <= mid) {
                rightMax = query(root.right, mid + 1, end);
            } else {
                rightMax = query(root.right, start, end);
            }
        }

        return Math.max(leftMax, rightMax);
    }

}
