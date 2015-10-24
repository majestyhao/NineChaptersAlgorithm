package DataStructure.Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hao on 15-10-23.
 */

public class Trie {
    class TrieNode {
        // Initialize your data structure here.
        char c;
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode() {

        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.children;
            if (i == word.length() - 1) {
                node.isWord = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        Map<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!children.containsKey(c)) {
                return false;
            } else {
                TrieNode node = children.get(c);
                children = node.children;
                if (i == word.length() - 1 && !node.isWord) {
                    return false;
                }
            }
        }

        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
        Map<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!children.containsKey(c)) {
                return false;
            } else {
                TrieNode node = children.get(c);
                children = node.children;
            }
        }

        return true;
    }
}
