package com.fleetup.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;

/**
 * @author David Hua
 * @date 2019/12/18
 * @desc
 */
public class StreamDataLogHandler implements RequestHandler<KinesisEvent, Void> {

    @Override
    public Void handleRequest(KinesisEvent event, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("accept request ");
        for(KinesisEvent.KinesisEventRecord rec : event.getRecords()) {
            String stringData = new String(rec.getKinesis().getData().array());
            for (String str : stringData.split("\\|")) {
                System.out.println(str);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String temp = "123|435|123123|";
        for (String s : temp.split("\\|")) {
            System.out.println("result=" + s);
        }
    }
}
