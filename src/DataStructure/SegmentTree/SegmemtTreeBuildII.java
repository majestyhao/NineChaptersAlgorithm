package DataStructure.SegmentTree;

/**
 * Created by hao on 15-10-26.
 */
public class SegmemtTreeBuildII {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return buildHelper(0, nums.length - 1, nums);
    }

    private SegmentTreeNode buildHelper(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MAX_VALUE);
        if (start != end) {
            int mid = start + (end - start) / 2;
            root.left = buildHelper(start, mid, nums);
            root.right = buildHelper(mid + 1, end, nums);
            root.max = Math.max(root.left.max, root.right.max);
        } else {
            root.max = nums[start];
        }

        return root;
    }
}
