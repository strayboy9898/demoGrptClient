package com.demo.spring.grpc.core.controller;

import com.demo.spring.grpc.core.schema.CheckDriverId;
import com.demo.spring.grpc.core.schema.PingRequest;
import com.demo.spring.grpc.core.service.PongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class PingController {
    @Autowired
    private PongService pongService;

    @PostMapping(path = "/pingClient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ping(@RequestBody PingRequest request) {
        return ResponseEntity.ok(pongService.ping(request));
    }

    @PostMapping(path = "/checkEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkEntity(@RequestBody CheckDriverId request) {
        return ResponseEntity.ok(pongService.checkDriver(request));
    }

}
