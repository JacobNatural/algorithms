package com.app.huffman;

import java.util.*;

/**
 * The type Huffman pack.
 */
public class HuffmanPack {

    private final String text;
    private final Map<Character, String> code;

    private HuffmanPack (String text, Map<Character, String> map) {
        this.text = text;
        this.code = map;
        createHuffmanBinaryTree();
    }

    /**
     * Of huffman pack.
     *
     * @param text the text
     * @return the huffman pack
     */
    public static HuffmanPack of(String text){

        if(text == null){
            throw new IllegalArgumentException("Text is null");
        }

        if(text.isEmpty()){
            throw new IllegalArgumentException("Text is empty");
        }

        return new HuffmanPack(text, new HashMap<>());
    }


    private Map<Character, Integer> calculateLetter(){
        Map<Character, Integer> lettersAndAmount = new HashMap<>();

        for(Character c : text.toCharArray()){
            lettersAndAmount.merge(c, 1, (v1, v2) -> v1 + 1);
        }

        return lettersAndAmount;
    }

    private void createHuffmanBinaryTree(){

        Node root;
        Map<Character, Integer> letterAndAmount = calculateLetter();
        List<Node> nodeList = new ArrayList<>();

        for(Map.Entry<Character, Integer> entry : letterAndAmount.entrySet()){
            nodeList.add(new Node(entry.getValue(), entry.getKey()));
        }

        nodeList.sort(Comparator.comparingInt(node -> node.key));

        root = new Node(nodeList.get(0).key + nodeList.get(1).key, '-');
        root.left = nodeList.get(0);
        root.right = nodeList.get(1);

        for(int i = 2; i < nodeList.size(); i++){
            var newNodeTemp = new Node(root.key + nodeList.get(i).key, '-');
            newNodeTemp.left = root;
            newNodeTemp.right = nodeList.get(i);
            root = newNodeTemp;
        }

        creatTableHuffman(root, "");
    }

    private void creatTableHuffman(Node focusNode, String s){

        if(focusNode != null) {
            if(Character.isLetter(focusNode.sign) || focusNode.sign == ' '){
                code.put(focusNode.sign, s);
            }
            creatTableHuffman(focusNode.left, s +"0");
            creatTableHuffman(focusNode.right,  s +  "1");
        }
    }

    /**
     * Pack map.
     *
     * @return the map
     */
    public Map<String,Map<Character, String>> pack(){

        var result = new StringBuilder();

        for(var sign : text.toCharArray()){
            result.append(code.get(sign));
        }

        return new HashMap<>(Map.of(result.toString(), code));
    }
}
