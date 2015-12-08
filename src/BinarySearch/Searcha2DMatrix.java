package BinarySearch;

/**
 * Created by hao on 15-12-7.
 */
public class Searcha2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int[] coord = oneDTo2D(mid, n);
            int x = coord[0];
            int y = coord[1];
            if (matrix[x][y] == target) {
                end = mid;
            } else if (matrix[x][y] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int[] coord = oneDTo2D(start, n);
        int x = coord[0];
        int y = coord[1];
        if (matrix[x][y] == target) {
            return true;
        }
        coord = oneDTo2D(end, n);
        x = coord[0];
        y = coord[1];
        return matrix[x][y] == target;

    }

    private int[] oneDTo2D(int index, int n) {
        int[] res = new int[2];
        res[0] = index / n;
        res[1] = index % n;
        return res;
    }
}
