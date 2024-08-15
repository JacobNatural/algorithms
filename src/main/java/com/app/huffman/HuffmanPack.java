package com.app.huffman;

import java.util.*;

/**
 * The {@code HuffmanPack} class implements Huffman encoding for text compression.
 * It encodes the given text using Huffman coding, creating a binary tree and generating a binary code table.
 */
public class HuffmanPack {

    /**
     * The text to be encoded using Huffman encoding.
     */
    private final String text;

    /**
     * The Huffman code mapping for each character in the text.
     */
    private final Map<Character, String> code;

    /**
     * Private constructor to initialize the HuffmanPack with the given text and code map.
     * The Huffman binary tree is created during initialization.
     *
     * @param text The text to be encoded.
     * @param map  The map to store the Huffman codes for each character.
     */
    private HuffmanPack(String text, Map<Character, String> map) {
        this.text = text;
        this.code = map;
        createHuffmanBinaryTree();
    }

    /**
     * Static factory method to create a new HuffmanPack instance.
     *
     * @param text The text to be encoded using Huffman coding.
     * @return A new HuffmanPack instance with the provided text.
     * @throws IllegalArgumentException If the text is null or empty.
     */
    public static HuffmanPack of(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text is null");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }

        return new HuffmanPack(text, new HashMap<>());
    }

    /**
     * Calculates the frequency of each character in the input text.
     *
     * @return A map where the key is the character, and the value is the frequency of that character in the text.
     */
    private Map<Character, Integer> calculateLetter() {
        Map<Character, Integer> lettersAndAmount = new HashMap<>();

        for (Character c : text.toCharArray()) {
            lettersAndAmount.merge(c, 1, Integer::sum);
        }

        return lettersAndAmount;
    }

    /**
     * Creates the Huffman binary tree based on character frequencies in the text.
     * The tree is built by merging nodes with the lowest frequencies, and a Huffman code table is generated.
     */
    private void createHuffmanBinaryTree() {
        Node root;
        Map<Character, Integer> letterAndAmount = calculateLetter();
        List<Node> nodeList = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : letterAndAmount.entrySet()) {
            nodeList.add(new Node(entry.getValue(), entry.getKey()));
        }

        nodeList.sort(Comparator.comparingInt(node -> node.key));

        root = new Node(nodeList.get(0).key + nodeList.get(1).key, '-');
        root.left = nodeList.get(0);
        root.right = nodeList.get(1);

        for (int i = 2; i < nodeList.size(); i++) {
            var newNodeTemp = new Node(root.key + nodeList.get(i).key, '-');
            newNodeTemp.left = root;
            newNodeTemp.right = nodeList.get(i);
            root = newNodeTemp;
        }

        creatTableHuffman(root, "");
    }

    /**
     * Recursively creates the Huffman code table by traversing the binary tree.
     * A '0' is added for each left traversal and '1' for each right traversal.
     *
     * @param focusNode The current node in the Huffman binary tree.
     * @param s         The binary string representing the path from the root to the current node.
     */
    private void creatTableHuffman(Node focusNode, String s) {
        if (focusNode != null) {
            if (Character.isLetter(focusNode.sign) || focusNode.sign == ' ') {
                code.put(focusNode.sign, s);
            }
            creatTableHuffman(focusNode.left, s + "0");
            creatTableHuffman(focusNode.right, s + "1");
        }
    }

    /**
     * Encodes the input text using the generated Huffman code table.
     *
     * @return A map where the key is the encoded text (binary string) and the value is the Huffman code table.
     */
    public Map<String, Map<Character, String>> pack() {
        var result = new StringBuilder();

        for (var sign : text.toCharArray()) {
            result.append(code.get(sign));
        }

        return new HashMap<>(Map.of(result.toString(), code));
    }

    /**
     * The {@code Node} class represents a node in the Huffman binary tree.
     */
    private static class Node {
        int key;
        char sign;
        Node left;
        Node right;

        Node(int key, char sign) {
            this.key = key;
            this.sign = sign;
        }
    }
}
