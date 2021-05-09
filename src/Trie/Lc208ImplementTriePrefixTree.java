package Trie;

public class Lc208ImplementTriePrefixTree {
    class Trie {
        // Fields
        class TrieNode {
            boolean isWord;
            TrieNode[] children;
            TrieNode() {
                isWord = false;
                children = new TrieNode[256];
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curNode.children[index] == null) {
                    curNode.children[index] = new TrieNode();
                }
                curNode = curNode.children[index];
            }
            curNode.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curNode.children[index] == null) return false;
                curNode = curNode.children[index];
            }
            return curNode.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (curNode.children[index] == null) return false;
                curNode = curNode.children[index];
            }
            return true;
        }
    }
}
