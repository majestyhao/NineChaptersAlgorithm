package DataStructure.SegmentTree;

import java.util.ArrayList;

/**
 * Created by hao on 15-10-26.
 */
public class IntervalSum {
    /**
     *@param nums, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] nums, ArrayList<Interval> queries) {
        root = build(0, nums.length - 1, nums);
        ArrayList<Long> res = new ArrayList<Long>();
        for (Interval que : queries) {
            res.add(query(que.start, que.end));
        }

        return res;
    }

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
}
