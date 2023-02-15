package com.demo.spring.grpc.core.service;

import com.demo.spring.grpc.core.schema.CoreServiceGrpc;
import com.demo.spring.grpc.core.schema.PingRequest;
import com.demo.spring.grpc.core.schema.PingResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.demo.spring.grpc.core.schema.CheckDriverId;
import com.demo.spring.grpc.core.schema.DriverEntity;

@Service
@Slf4j
public class PongService {
    public PingResponse ping(PingRequest request) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6790)
                .usePlaintext()
                .build();
        CoreServiceGrpc.CoreServiceBlockingStub stub
                = CoreServiceGrpc.newBlockingStub(channel);

        PingResponse helloResponse = stub.ping(request);

        channel.shutdown();
        return helloResponse;
    }

    public DriverEntity checkDriver(CheckDriverId checkDriverId) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6790)
                .usePlaintext()
                .build();
        CoreServiceGrpc.CoreServiceBlockingStub stub
                = CoreServiceGrpc.newBlockingStub(channel);

        DriverEntity driverEntity = stub.checkDriver(checkDriverId);

        channel.shutdown();
        return driverEntity;
    }
}
