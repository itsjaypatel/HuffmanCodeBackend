package com.itsjaypatel.huffmancoding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownloadS3Response {

    private URL url;
    private boolean status;
    private String msg;
}
