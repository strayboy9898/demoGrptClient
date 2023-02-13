package com.demo.spring.grpc.core.controller;

import com.demo.spring.grpc.core.schema.CoreServiceGrpc;
import com.demo.spring.grpc.core.schema.PingRequest;
import com.demo.spring.grpc.core.schema.PingResponse;
import com.demo.spring.grpc.core.service.PongService;


import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@GRpcService
public class GrpcController extends CoreServiceGrpc.CoreServiceImplBase {
    @Autowired
    private PongService pongService;

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        responseObserver.onNext(pongService.ping(request));
        responseObserver.onCompleted();
    }
}
