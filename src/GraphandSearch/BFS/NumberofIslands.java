package GraphandSearch.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hao on 15-10-23.
 */
public class NumberofIslands {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        Queue<Integer> queue = new LinkedList<>();

        int res = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = twoDToOneD(i, j, m);
                if (!grid[i][j] || visited[index]) {
                    continue;
                }
                queue.add(index);
                res++;
                while (!queue.isEmpty()) {
                    int len = queue.size();
                    for (int k = 0; k < len; k++) {
                        int node = queue.remove();
                        if (visited[node]) {
                            continue;
                        }
                        visited[node] = true;
                        int[] xy = oneDToTwoD(node, m);
                        for (int p = 0; p < 4; p++) {
                            int newX = xy[0] + dx[p];
                            int newY = xy[1] + dy[p];
                            if (newX < m && newX >= 0 && newY < n && newY >= 0
                                    && grid[newX][newY]) {
                                int newIndex = twoDToOneD(newX, newY, m);
                                queue.add(newIndex);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    private int twoDToOneD(int x, int y, int m) {
        return x * m + y;
    }

    private int[] oneDToTwoD(int index, int m) {
        int[] res = new int[2];
        res[0] = index / m;
        res[1] = index % m;

        return res;
    }
}
