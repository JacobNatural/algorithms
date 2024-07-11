package com.app.huffman;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The type Node.
 */
@RequiredArgsConstructor
@ToString
public class Node {
    /**
     * The Key.
     */
    final int key;
    /**
     * The Sign.
     */
    final char sign;
    /**
     * The Left.
     */
    Node left;
    /**
     * The Right.
     */
    Node right;

    /**
     * Check node key boolean.
     *
     * @param node the node
     * @return the boolean
     */

    public boolean checkNodeKey(Node node){
        if(node == null){
            throw  new IllegalArgumentException("Node is null");
        }
        return key < node.key;
    }
}
