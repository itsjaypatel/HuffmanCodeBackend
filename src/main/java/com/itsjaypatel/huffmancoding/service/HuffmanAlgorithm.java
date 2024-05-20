package com.itsjaypatel.huffmancoding.service;


import com.itsjaypatel.huffmancoding.util.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


public class HuffmanAlgorithm {

    @Getter
    private final Map<Character,String> normalMapping = new HashMap<>();

    @Getter
    @Setter
    private  Map<String,Character> reverseMapping = new HashMap<>();

    private final Integer segment = 7;

    public void createHuffmanTree(String text){

        Map<Character,Integer> frequencyMap = HuffmanAlgorithm.buildFrequencyMap(text);
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        for (Map.Entry<Character,Integer> entry : frequencyMap.entrySet()){
            minHeap.offer(Node.builder().character(entry.getKey()).frequency(entry.getValue()).build());
        }

        Node node = null;
        while(minHeap.size() > 1){
            Node left = minHeap.poll();
            Node right = minHeap.poll();
            int sum = left.getFrequency() + right.getFrequency();
            Node merged = Node.builder().frequency(sum).right(right).left(left).build();
            minHeap.offer(merged);
        }

        node = minHeap.poll();
        generateCharacterCodes(node,new StringBuilder());
        //System.out.println("Reverse Mapping: " + reverseMapping);
    }


    void generateCharacterCodes(Node node, StringBuilder currentCode){

        if(node == null){
            return;
        }

        Character character = node.getCharacter();
        if(character != null){
            normalMapping.put(character, currentCode.toString());
            reverseMapping.put(currentCode.toString(),character);
            return;
        }

        currentCode.append("0");
        generateCharacterCodes(node.getLeft(),currentCode);
        currentCode.deleteCharAt(currentCode.length() - 1);

        currentCode.append("1");
        generateCharacterCodes(node.getRight(),currentCode);
        currentCode.deleteCharAt(currentCode.length() - 1);
    }
    public String encodingText(String text) {

        StringBuilder encodedText = new StringBuilder();
        for(char character : text.toCharArray()){
            String characterCode = normalMapping.get(character);
            encodedText.append(characterCode);
        }
        // encodedText= 0101
        // bits = 0000000
        // extrapadding = 7 - 4 = 3 = 3

        String bits = "00000000".substring(0, 7);
        int extraPadding  = segment - encodedText.length()%7;
        encodedText.append(bits, 0, extraPadding);

        String paddingInfo = Integer.toBinaryString(extraPadding);
        paddingInfo = bits.substring(0,7 - paddingInfo.length()) + paddingInfo;
        encodedText.insert(0,paddingInfo);

        return encodedText.toString();
    }

    public String decodingText(String paddedEncodedText) {

        if(paddedEncodedText.isBlank()){
            return "";
        }
        String paddingInfo = paddedEncodedText.substring(0,segment);
        int extraPadding = Integer.parseInt(paddingInfo,2);
        String encodedText =  paddedEncodedText.substring(segment,paddedEncodedText.length() - extraPadding);

        Map<String,Character> map = reverseMapping;
        StringBuilder currentCode = new StringBuilder();
        StringBuilder decodedText = new StringBuilder();
        for(char bit : encodedText.toCharArray()){
            currentCode.append(bit);
            if(map.containsKey(currentCode.toString())){
                decodedText.append(map.get(currentCode.toString()));
                currentCode.setLength(0);
            }
        }
        return decodedText.toString();
    }

    private static Map<Character,Integer> buildFrequencyMap(String text) {
        Map<Character,Integer> frequencyMap = new HashMap<>();

        for(char ch : text.toCharArray()){
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0) + 1);
        }
        return frequencyMap;
    }
}