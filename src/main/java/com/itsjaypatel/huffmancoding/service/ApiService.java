package com.itsjaypatel.huffmancoding.service;

import com.itsjaypatel.huffmancoding.dto.DecodeRequest;
import com.itsjaypatel.huffmancoding.dto.DecodeResponse;
import com.itsjaypatel.huffmancoding.dto.EncodeRequest;
import com.itsjaypatel.huffmancoding.dto.EncodeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@AllArgsConstructor
public class ApiService {

    public EncodeResponse encode(EncodeRequest request){

        String text = request.getText();

        HuffmanAlgorithm huffmanAlgorithm = new HuffmanAlgorithm();
        huffmanAlgorithm.createHuffmanTree(text);

        String binaryText = huffmanAlgorithm.encodingText(text);
        Map keyMap = huffmanAlgorithm.getReverseMapping();
        return EncodeResponse.builder().binaryText(binaryText).keyMap(keyMap).build();

    }

    public DecodeResponse decode(DecodeRequest request){
        String binaryText = request.getBinaryText();
        Map keyMap = request.getKeyMap();

        HuffmanAlgorithm huffmanAlgorithm = new HuffmanAlgorithm();
        huffmanAlgorithm.setReverseMapping(keyMap);
        String plainText = huffmanAlgorithm.decodingText(binaryText);

        return DecodeResponse.builder().text(plainText).build();
    }
}
