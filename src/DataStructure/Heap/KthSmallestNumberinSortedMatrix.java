package DataStructure.Heap;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hao on 15-10-22.
 */
public class KthSmallestNumberinSortedMatrix {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public class Point {
        public int x, y, val;
        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point a, Point b) {
            return a.val - b.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
       return horizontal(matrix, k);
    }

    private int horizontal(int[][] matrix, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<>(k, new PointComparator());
        for (int i = 0; i < Math.min(k, matrix.length); i++) {
            heap.offer(new Point(i, 0, matrix[i][0]));
        }

        for (int i = 0; i < k - 1; i++) {
            Point curr = heap.poll();
            if (curr.y + 1 < matrix[0].length) {
                heap.offer(new Point(curr.x, curr.y + 1, matrix[curr.x][curr.y + 1]));
            }
        }

        return heap.peek().val;
    }

    public static void main(String[] args) {
        KthSmallestNumberinSortedMatrix ks = new KthSmallestNumberinSortedMatrix();
        //int[][] input = {{1,2,3,4,5},{2,3,4,5,6}, {3,4,5,6,7},{4,5,6,7,8}};
        int[][] input = {{1,5,7},{3,7,8},{4,8,9}};
        System.out.print(ks.kthSmallest(input, 4));
    }
}
