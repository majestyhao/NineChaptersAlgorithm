package DataStructure.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hao on 15-10-23.
 */
public class WordSearchII {
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        Trie trie = new Trie();
        ArrayList<String> res = new ArrayList<>();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        if (m == 0) {
            return res;
        }
        int n = board[0].length;
        List<Character> list = new ArrayList<Character>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, list, board, res, trie.root, m, n);
            }
        }

        return res;
    }

    private void dfs(int x, int y, List<Character> list, char[][] board,
                     ArrayList<String> res, Trie.TrieNode node, int m, int n) {
        if (!list.isEmpty() && node.isWord) {
            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                sb.append(c);
            }
            if (!res.contains(sb.toString())) {
                res.add(sb.toString());
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < m && newX >= 0 && newY < n
                    && newY >= 0 ) {
                char cur = board[newX][newY];
                if (node.children.containsKey(cur)){
                    board[newX][newY] = 0;
                    list.add(cur);
                    dfs(newX, newY, list, board, res, node.children.get(cur), m, n);
                    list.remove(list.size() - 1);
                    board[newX][newY] = cur;
                }
            }
        }
    }

    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();
        char[][] source = new char[1][];
        source[0] = new char[5];
        source[0][0] = 'a';
        source[0][1] = 'p';
        source[0][2] = 'p';
        source[0][3] = 'l';
        ArrayList<String> dict = new ArrayList<>();
        dict.add("app");
        ws.wordSearchII(source, dict);
    }
}
