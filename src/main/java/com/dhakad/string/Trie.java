package com.dhakad.string;

import java.util.Objects;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        TrieNode current = root;
        for(char c : word.toCharArray()){
            current = current.getChildren().computeIfAbsent(c, t -> new TrieNode());
        }
        current.setEndOfWard(true);
    }

    boolean search(String word){
        TrieNode current = root;
        for(char c : word.toCharArray()){
            TrieNode node = current.getChildren().get(c);
            if (Objects.isNull(node)){
                return false;
            }
            current = node;
        }
        return current.isEndOfWard();
    }
}
