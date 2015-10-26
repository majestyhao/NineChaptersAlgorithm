package GraphandSearch.DFS;

/**
 * Created by hao on 15-10-26.
 */
public class WordSearch {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        boolean[] res = new boolean[1];

        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                dfs(i, j, board, 0, word, m, n, res, visited);
                visited[i][j] = false;
            }
        }

        return res[0];
    }

    private void dfs(int x, int y, char[][] board,
                     int pos, String word, int m, int n, boolean[] res, boolean[][] visited) {
        if (board[x][y] != word.charAt(pos)) {
            return;
        }
        if (res[0] || pos == word.length() - 1) {
            res[0] = true;
            return;
        }


        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        //visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < m && newX >= 0 && newY < n
                    && newY >= 0 && !visited[newX][newY]) {
                visited[newX][newY] = true;
                dfs(newX, newY, board, pos + 1, word, m, n, res, visited);
                visited[newX][newY] = false;
            }
        }
        //visited[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        String tmp = "abc";
        board[0] = tmp.toCharArray();
        tmp = "aed";
        board[1] = tmp.toCharArray();
        tmp = "afg";
        board[2] = tmp.toCharArray();
        tmp = "abcdefg";
        WordSearch ws = new WordSearch();
        ws.exist(board, tmp);
    }
}
