package com.itsjaypatel.huffmancoding.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadS3Request {


    private String s3Key;

    private String s3Bucket;
}
