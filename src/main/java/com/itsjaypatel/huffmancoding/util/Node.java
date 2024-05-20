package com.itsjaypatel.huffmancoding.util;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Node implements Comparable<Node>{


    private int frequency;

    private Character character;

    private Integer characterCode;

    private Node left;

    private Node right;

    public int compareTo(Node that) {
        int f1 = this.frequency;
        int f2 = that.frequency;
        return f1  - f2;
    }
}
