package DataStructure.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hao on 15-10-22.
 */
public class TrappingRainWaterII {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    class Cell {
        int height;
        int x, y;
        Cell (int height, int x, int y) {
            this.height = height;
            this.x = x;
            this.y = y;
        }
    }

    public int trapRainWater(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<>(n, new CellComparator());
        Cell cell = null;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            cell = new Cell(heights[0][i], 0, i);
            heap.add(cell);
            flag[0][i] = true;
            cell = new Cell(heights[m - 1][i], m - 1, i);
            heap.add(cell);
            flag[m - 1][i] = true;
        }
        for (int i = 1; i < m - 1; i++) {
            cell = new Cell(heights[i][0], i, 0);
            heap.add(cell);
            flag[i][0] = true;
            cell = new Cell(heights[i][n - 1], i, n - 1);
            heap.add(cell);
            flag[i][n - 1] = true;
        }

        int res = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!heap.isEmpty()) {
            cell = heap.remove();
            int x = cell.x;
            int y = cell.y;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX <= m - 1
                        && newY >= 0 && newY <= n - 1) {
                    if (!flag[newX][newY]) {
                        //heap.add(new Cell(heights[newX][newY], newX, newY));
                        heap.offer(new Cell(Math.max(cell.height, heights[newX][newY]), newX, newY));
                        flag[newX][newY] = true;
                        if (heights[newX][newY] < cell.height) {
                            res += cell.height - heights[newX][newY];
                        }
                    }
                }
            }
        }

        return res;
    }

    public class CellComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell a, Cell b) {
            return a.height - b.height;
        }
    }
}
