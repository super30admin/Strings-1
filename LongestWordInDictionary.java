// DFS Solution
// Time Complexity : O(n*k)
// Space Complexity : O(n*k)
// Did this code successfully run on Leetcode : Yes


import java.util.*;

public class LongestWordInDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        char ch;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.ch = c;
        }
        curr.isEnd = true;
    }
    StringBuilder result;
    public String longestWord(String[] words) {
        root = new TrieNode(); // new TrieNode initiated
        result = new StringBuilder();
        for(String word: words) {
            insert(word);
        }
        backtrack(root, new StringBuilder());
        return result.toString();
    }

    private void backtrack(TrieNode curr, StringBuilder currStr) {
        // base
        if(result.length() < currStr.length()) {
            result = new StringBuilder(currStr);
        }
        // logic
        for(int i = 0; i < 26; i++) {
            if(curr.children[i] != null && curr.children[i].isEnd) {
                // action
                currStr.append(curr.children[i].ch);
                // recurse
                backtrack(curr.children[i], currStr);
                // backtrack
                currStr.setLength(currStr.length() - 1);
            }
        }
    }
}

// BFS Solution
// Time Complexity : O(n*k)
// Space Complexity : O(n*k)
// Did this code successfully run on Leetcode : Yes

class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            word ="";
        }
    }
    TrieNode root = new TrieNode();;

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.word = word;
        curr.isEnd = true;
    }

    public String longestWord(String[] words) {
        for(String word: words) {
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        while(!q.isEmpty()) {
            curr = q.poll();
            for(int i = 25; i >= 0; i--) {
                if(curr.children[i] != null && curr.children[i].isEnd) {
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
}