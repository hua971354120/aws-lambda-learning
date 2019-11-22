package com.fleetup.lambda.log.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

/**
 * @author SZ Team David Hua
 * @date 2019/11/22
 * @desc
 */
public class LambdaLogHandler {
    public void handle(Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Lambda log");
    }
}
