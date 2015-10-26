package DataStructure.SegmentTree;

import java.util.ArrayList;

/**
 * Created by hao on 15-10-26.
 */
public class IntervalMinimumNumber {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] nums, ArrayList<Interval> queries) {
        SegTree segTree = new SegTree();
        SegTreeNode root = segTree.buildTree(0, nums.length - 1, nums);
        ArrayList<Integer> res = new ArrayList<>();
        for (Interval que : queries) {
            res.add(segTree.query(root, que.start, que.end));
        }

        return res;
    }

    class SegTreeNode {
        int start, end, min;
        SegTreeNode left, right;
        SegTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
            left = null; right = null;
        }
    }

    class SegTree {
        public SegTreeNode buildTree (int start, int end, int[] nums) {
            if (end < start) {
                return null;
            }
            SegTreeNode root = new SegTreeNode(start, end, Integer.MAX_VALUE);
            if (start == end) {
                root.min = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                root.left = buildTree(start, mid, nums);
                root.right = buildTree(mid + 1, end, nums);
                root.min = Math.min(root.left.min, root.right.min);
            }

            return root;
        }

        public int query(SegTreeNode root, int start, int end) {
            if (root.start == start && root.end == end) {
                return root.min;
            }

            int mid = root.start + (root.end - root.start) / 2;
            int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
            if (start <= mid) {
                if (mid < end) {
                    leftMin = query(root.left, start, mid);
                } else {
                    leftMin = query(root.left, start, end);
                }
            }
            if (mid < end) {
                if (start <= mid) {
                    rightMin = query(root.right, mid + 1, end);
                } else {
                    rightMin = query(root.right, start, end);
                }
            }

            return Math.min(leftMin, rightMin);
        }
    }
}
