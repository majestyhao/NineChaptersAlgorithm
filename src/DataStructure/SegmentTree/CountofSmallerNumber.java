package DataStructure.SegmentTree;

import java.util.ArrayList;

/**
 * Created by hao on 15-10-26.
 */
public class CountofSmallerNumber {
    /**
     * @param nums: An integer array
     * @return: The number of element in the array that
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] nums, int[] queries) {
        root = build(0, 10000);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            modify(root.left, nums[i], 1);
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > 0) {
                res.add(query(root, 0, queries[i] - 1));
            } else {
                res.add(0);
            }
        }

        return res;
    }

    class SegTreeNode {
        int start, end, count;
        SegTreeNode left, right;
        SegTreeNode (int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            left = null; right = null;
        }
    }

    SegTreeNode root;

    private SegTreeNode build(int start, int end) {
        if (end < start) {
            return null;
        }

        SegTreeNode root = new SegTreeNode(start, end, 0);
        if (start != end) {
            int mid = start + (end - start) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        } else {
            root.count = 0;
        }

        return root;
    }

    private void modify(SegTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.count += value;
            return;
        }

        int mid = root.start + (root.end - root.start) / 2;
        /*if (mid < index) {
            modify(root.right, index, value);
        } else {
            modify(root.left, index, value);
        }*/
        if (root.start <= index && index <= mid) {
            modify(root.left, index, value);
        } else if (mid < index && index <= root.end){
            modify(root.right, index, value);
        }

        root.count = root.left.count + root.right.count;
    }

    private int query(SegTreeNode root, int start, int end) {
        if (end < start || root == null) {
            return 0;
        }

        if (root.start == start && root.end == end) {
            return root.count;
        }

        int mid = root.start + (root.end - root.start) / 2;
        int leftCount = 0, rightCount = 0;
        if (mid < end) {
            if (start <= mid) {
                leftCount = query(root.right, mid + 1, end);
            } else {
                leftCount = query(root.right, start, end);
            }
        }

        if (start <= mid) {
            if (mid  < end) {
                rightCount = query(root.left, start, mid);
            } else {
                rightCount = query(root.left, start, end);
            }
        }

        return leftCount + rightCount;
    }
}
