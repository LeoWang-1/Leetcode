package Trie;

import java.util.*;

public class Lc642DesignSearchAutocompleteSystem {
    class AutocompleteSystem {
        // Fields
        class Trie {
            String sentence;
            boolean isSentence;
            int times;
            Trie[] children;
            Trie() {
                sentence = "";
                isSentence = false;
                times = 0;
                children = new Trie[27];
            }
        }

        class Node {
            String sentence;
            int times;
            Node(String sentence, int times) {
                this.sentence = sentence;
                this.times = times;
            }
        }

        Trie root = new Trie();
        String curSentence = "";
        public AutocompleteSystem(String[] sentences, int[] times) {
            // Build map: sentence to times
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < sentences.length; i++) {
                if (map.containsKey(sentences[i])) {
                    int totalNum = map.get(sentences[i]) + times[i];
                    map.put(sentences[i], totalNum);
                } else {
                    map.put(sentences[i], times[i]);
                }
            }

            // Build Trie
            for (String sentence : sentences) {
                buildTrie(sentence, map.get(sentence));
            }

        }

        private void buildTrie(String sentence, int time) {
            Trie curNode = root;
            for (int i = 0; i < sentence.length(); i++) {

                if (sentence.charAt(i) == ' ') {
                    if (curNode.children[26] == null) {
                        curNode.children[26] = new Trie();

                    }
                    curNode = curNode.children[26];
                } else {
                    int index = sentence.charAt(i) - 'a';
                    if (curNode.children[index] == null) {
                        curNode.children[index] = new Trie();
                    }
                    curNode = curNode.children[index];
                }
            }
            curNode.sentence = sentence;
            curNode.isSentence = true;
            curNode.times += time;
        }

        public List<String> input(char c) {
            if (c == '#') {
                buildTrie(curSentence, 1);
                curSentence = "";
                return new ArrayList<>();
            }

            curSentence += c;
            PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);

            Trie curNode = root;
            searchTrie(curSentence, curNode, 0, maxHeap);

            List<String> res = new ArrayList<>();
            while (!maxHeap.isEmpty()) {
                res.add(maxHeap.poll().sentence);
                if (res.size() == 3) break;
            }
            maxHeap.clear();

            return res;
        }

        private void searchTrie(String curSentence, Trie curNode, int index, PriorityQueue<Node> maxHeap) {
            // Base case
            if (curNode == null) return;

            // Next step
            if (index < curSentence.length()) {
                char ch = curSentence.charAt(index);
                if (ch == ' ') {
                    searchTrie(curSentence, curNode.children[26], index + 1, maxHeap);
                } else {
                    searchTrie(curSentence, curNode.children[ch - 'a'], index + 1, maxHeap);
                }
            } else {
                if (curNode.isSentence) {
                    maxHeap.offer(new Node(curNode.sentence, curNode.times));
                }

                for (Trie child : curNode.children) {
                    searchTrie(curSentence, child, index, maxHeap);
                }
            }
        }
    }
}
