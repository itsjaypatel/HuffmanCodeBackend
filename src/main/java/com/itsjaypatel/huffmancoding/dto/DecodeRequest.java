package com.itsjaypatel.huffmancoding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
@Builder
public class DecodeRequest {

    private final String binaryText;

    private final Map keyMap;
}
