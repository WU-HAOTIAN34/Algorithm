package com.leetcode;

public class LeeCo208Sol {

    public Trie tire(){return new Trie();}

    class Trie {

        class TrieNode{
            TrieNode[] next;
            Character c;
            Boolean end;
            TrieNode(char ch){
                this.next = new TrieNode[100];
                this.c = ch;
                this.end = false;
            }
        }

        TrieNode beg;

        public Trie() {
            beg = new TrieNode(' ');
        }

        public void insert(String word) {
            TrieNode t = beg;
            for (char c : word.toCharArray()){
                if (t.next[c-'A']==null){
                    t.next[c-'A'] = new TrieNode(c);
                }
                t = t.next[c-'A'];
            }
            t.end = true;
        }

        public boolean search(String word) {
            TrieNode t = beg;
            for (char c : word.toCharArray()){
                if (t.next[c-'A']==null){
                    return false;
                }
                t = t.next[c-'A'];
            }
            return t.end;
        }

        public boolean startsWith(String prefix) {
            TrieNode t = beg;
            for (char c : prefix.toCharArray()){
                if (t.next[c-'A']==null){
                    return false;
                }
                t = t.next[c-'A'];
            }
            if (t.end) return true;
            for (TrieNode tn : t.next){
                if (tn != null) return true;
            }
            return false;
        }
    }
}
