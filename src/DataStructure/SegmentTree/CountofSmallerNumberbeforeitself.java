package DataStructure.SegmentTree;

import java.util.ArrayList;

/**
 * Created by hao on 15-10-27.
 */
public class CountofSmallerNumberbeforeitself {
    /**
     * @param nums: An integer array
     * @return: Count the number of element before this element 'ai' is
     *          smaller than it and return count number array
     */
    public ArrayList<Integer> countOfSmallerNumberII(int[] nums) {
        root = build(0, 10000);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(query(root, 0, nums[i] - 1));
            modify(root, nums[i], 1);
        }

        return res;
    }

    class SegTreeNode {
        int start, end, count;
        SegTreeNode left, right;
        SegTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            left = null; right = null;
        }
    }

    SegTreeNode root = null;

    private SegTreeNode build(int start, int end) {
        if (end < start) {
            return null;
        }

        SegTreeNode root = new SegTreeNode(start, end, 0);
        int mid = start + (end - start) / 2;
        if (start != end) {
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
            root.count = root.left.count + root.right.count;
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
}
