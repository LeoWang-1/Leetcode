package Trie;

public class Lc211DesignAddandSearchWordsDataStructure {
    class WordDictionary {
        // Fields
        class TrieNode {
            boolean isWord;
            TrieNode[] children;
            TrieNode() {
                isWord = false;
                children = new TrieNode[26];
            }
        }

        TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
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

        public boolean search(String word) {
            TrieNode curNode = root;
            return findWord(root, word, 0);
        }

        private boolean findWord(TrieNode root, String word, int index) {
            // Base case
            if (index == word.length()) return root.isWord;

            // Next step
            if (word.charAt(index) == '.') {
                for (TrieNode temp : root.children) {
                    if (temp != null && findWord(temp, word, index + 1)) return true;
                }
            } else {
                if (root.children[word.charAt(index) - 'a'] != null && findWord(root.children[word.charAt(index) - 'a'], word, index + 1)) return true;
            }
            return false;
        }
    }
}
