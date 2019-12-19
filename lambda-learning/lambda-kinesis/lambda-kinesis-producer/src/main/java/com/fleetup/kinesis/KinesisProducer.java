package com.fleetup.kinesis;

import com.amazonaws.services.kinesis.producer.KinesisProducerConfiguration;
import com.amazonaws.services.kinesis.producer.UserRecordResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

/**
 * @author David Hua
 * @date 2019/12/18
 * @desc
 */
public class KinesisProducer {

    private com.amazonaws.services.kinesis.producer.KinesisProducer kinesisProducer;

    private static final String DEFAULT_STREAM_NAME = "david-kinesis-test";
    private static final String DEFAULT_PARTITION_KEY = "shard-1";

    private final FutureCallback<UserRecordResult> myCallback = new FutureCallback<UserRecordResult>() {
        @Override
        public void onFailure(Throwable t) {
            System.out.println("send data error ");
        };
        @Override
        public void onSuccess(UserRecordResult result) {
            System.out.println("send data success ");
        };
    };

    public KinesisProducer() {
        KinesisProducerConfiguration configuration = new KinesisProducerConfiguration()
                .setRecordMaxBufferedTime(3000)
                .setMaxConnections(1)
                .setRequestTimeout(60000)
                .setRegion("ap-east-1");
        kinesisProducer = new com.amazonaws.services.kinesis.producer.KinesisProducer(configuration);
    }

    public void pushDataWithoutResult(String dataStr) {
        ByteBuffer byteBufferData = ByteBuffer.wrap(dataStr.getBytes(StandardCharsets.UTF_8));
        kinesisProducer.addUserRecord(DEFAULT_STREAM_NAME, DEFAULT_PARTITION_KEY, byteBufferData);
    }

    public void pushDataWithSyncResult(String dataStr) throws ExecutionException, InterruptedException {
        pushData(dataStr);
    }

    public void pushData(String dataStr) throws ExecutionException, InterruptedException {
        ByteBuffer byteBufferData = ByteBuffer.wrap(dataStr.getBytes(StandardCharsets.UTF_8));
        ListenableFuture<UserRecordResult> future = kinesisProducer.addUserRecord(DEFAULT_STREAM_NAME, DEFAULT_PARTITION_KEY, byteBufferData);
        if (future.get().isSuccessful()) {
            System.out.println("send data success");
        } else {
            System.out.println("send data error");
        }
    }

    public void pushDataWithAsyncResult(String dataStr) {
        ByteBuffer byteBufferData = ByteBuffer.wrap(dataStr.getBytes(StandardCharsets.UTF_8));
        ListenableFuture<UserRecordResult> future = kinesisProducer.addUserRecord(DEFAULT_STREAM_NAME, DEFAULT_PARTITION_KEY, byteBufferData);
        Futures.addCallback(future, myCallback);
    }
}
