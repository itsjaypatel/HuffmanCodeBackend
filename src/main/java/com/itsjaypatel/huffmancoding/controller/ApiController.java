package com.itsjaypatel.huffmancoding.controller;

import com.itsjaypatel.huffmancoding.dto.DecodeRequest;
import com.itsjaypatel.huffmancoding.dto.EncodeRequest;
import com.itsjaypatel.huffmancoding.service.ApiService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
    private ApiService apiService;

    @PostMapping("/encode")
    public ResponseEntity<?> encode(@RequestBody EncodeRequest request){
        LOGGER.info("Encode request: {}", request);
        return ResponseEntity.ok(apiService.encode(request));
    }


    @PostMapping("/decode")
    public ResponseEntity<?> decode(@RequestBody DecodeRequest request){
        LOGGER.info("Decode request: {}", request);
        return ResponseEntity.ok(apiService.decode(request));
    }
}
