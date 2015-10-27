package DataStructure.SegmentTree;

/**
 * Created by hao on 15-10-26.
 */
public class IntervalSumII {
    /* you may need to use some attributes here */
    class SegTreeNode {
        int start, end; long sum;
        SegTreeNode left, right;

        SegTreeNode (int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    SegTreeNode root = null;

    /**
     * @param nums: An integer array
     */
    public IntervalSumII(int[] nums) {
        root = build(0, nums.length - 1, nums);
    }

    private SegTreeNode build(int start, int end, int[] nums) {
        if (end < start) {
            return null;
        }

        SegTreeNode root = new SegTreeNode(start, end, 0);
        if (start == end) {
            root.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            root.left = build(start, mid, nums);
            root.right = build(mid + 1, end, nums);
            root.sum = root.left.sum + root.right.sum;
        }

        return root;
    }

    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return queryHelper(root, start, end);
    }

    private long queryHelper(SegTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }

        int mid = root.start + (root.end - root.start) / 2;
        long leftSum = 0, rightSum = 0;
        if (start <= mid) {
            if (mid < end) {
                leftSum = queryHelper(root.left, start, mid);
            } else {
                leftSum = queryHelper(root.left, start, end);
            }
        }

        if (mid < end) {
            if (start <= mid) {
                rightSum = queryHelper(root.right, mid + 1, end);
            } else {
                rightSum = queryHelper(root.right, start, end);
            }
        }

        return leftSum + rightSum;
    }

    /**
     * @param index, value: modify nums[index] to value.
     */
    public void modify(int index, int value) {
        modifyHelper(root, index, value);
    }

    private void modifyHelper(SegTreeNode root, int index, int value) {
        if (root.start == root.end && root.end == index) {
            root.sum = value;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        if (mid < index) {
            modifyHelper(root.right, index, value);
        } else {
            modifyHelper(root.left, index, value);
        }

        root.sum = root.left.sum + root.right.sum;
    }
}
