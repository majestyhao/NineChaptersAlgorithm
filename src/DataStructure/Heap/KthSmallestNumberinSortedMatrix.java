package DataStructure.Heap;

/**
 * Created by hao on 15-10-22.
 */
public class KthSmallestNumberinSortedMatrix {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] mat = new int[m * n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[count] = matrix[i][j];
                count++;
            }
        }

        heapify(mat);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = pull(mat);
        }

        return res;
    }

    private void heapify(int[] mat) {
        heapSize = mat.length;
        for (int i = mat.length / 2; i >= 0; i--) {
            siftDown(mat, i);
        }
    }

    private int heapSize;

    private void siftDown(int[] nums, int i) {
        while (i < heapSize) {
            int smallest = i;
            if (i * 2 + 1 < heapSize && nums[i * 2 + 1] < nums[smallest]) {
                smallest = i * 2 + 1;
            }
            if (i * 2 + 2 < heapSize && nums[i * 2 + 2] < nums[smallest]) {
                smallest = i * 2 + 2;
            }
            if (smallest == i) {
                break;
            }
            int tmp = nums[smallest];
            nums[smallest] = nums[i];
            nums[i] = tmp;
            i = smallest;
        }
    }

    private int pull(int[] nums) {
        int res = nums[0];
        nums[0] = nums[heapSize - 1];
        heapSize--;
        siftDown(nums, 0);

        return res;
    }

    public static void main(String[] args) {
        KthSmallestNumberinSortedMatrix ks = new KthSmallestNumberinSortedMatrix();
        int[][] input = {
                {1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},};
        System.out.print(ks.kthSmallest(input, 4));
    }
}
