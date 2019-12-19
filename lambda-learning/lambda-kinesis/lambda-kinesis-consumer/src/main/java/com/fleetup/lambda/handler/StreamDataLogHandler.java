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
            System.out.println(new String(rec.getKinesis().getData().array()));
        }
        return null;
    }
}
