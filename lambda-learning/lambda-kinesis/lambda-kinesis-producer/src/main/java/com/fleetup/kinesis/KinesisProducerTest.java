package com.fleetup.kinesis;

import java.util.concurrent.ExecutionException;

/**
 * @author David Hua
 * @date 2019/12/18
 * @desc
 */
public class KinesisProducerTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        KinesisProducer kinesisProducer = new KinesisProducer();
        if (args.length > 0) {
            for (String arg : args) {
                kinesisProducer.pushData(arg);
            }
        } else {
            kinesisProducer.pushData("Hello");
        }
    }
}
