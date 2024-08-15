package com.app.huffman;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The {@code Node} class represents a node in the Huffman binary tree used for encoding and decoding.
 * Each node contains a key representing the frequency of the character and the character itself.
 * It also has references to its left and right children in the tree.
 */
@RequiredArgsConstructor
@ToString
public class Node {

    /**
     * The frequency of the character (used as the key in the Huffman tree).
     */
    final int key;

    /**
     * The character represented by this node.
     */
    final char sign;

    /**
     * The left child node in the Huffman tree.
     */
    Node left;

    /**
     * The right child node in the Huffman tree.
     */
    Node right;

    /**
     * Compares the key of this node with another node.
     *
     * @param node The node to compare against.
     * @return {@code true} if this node's key is less than the other node's key, {@code false} otherwise.
     * @throws IllegalArgumentException If the provided node is null.
     */
    public boolean checkNodeKey(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Node is null");
        }
        return key < node.key;
    }
}