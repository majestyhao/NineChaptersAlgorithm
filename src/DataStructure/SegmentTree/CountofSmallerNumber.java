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
        // write your code here
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

    private SegTreeNode build(int start, int end) {
        if (end < start} {
            return null;
        }

        SegTreeNode root = new SegTreeNode(start, end, 0);
        if (start != end) {
            int mid = start + (end - start) / 2;
            root.left = (start, mid)
        root.right = (mid + 1, end)
    } else {
            root.count = 0;
        }
    }

    private void modify(SegTreeNode root, int index, value) {
        if (root.start == index && root.end == index) {

        }
    }
}
