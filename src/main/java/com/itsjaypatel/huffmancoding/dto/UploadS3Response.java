package com.itsjaypatel.huffmancoding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadS3Response {

    private String s3Key;

    private String s3Bucket;

    private boolean status;

    private String msg;
}
