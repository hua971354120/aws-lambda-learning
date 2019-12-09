package com.fleetup.lambda.log.handler;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author SZ Team David Hua
 * @date 2019/11/22
 * @desc
 */
public class Log4jHandler {

    private static final Logger logger = LogManager.getLogger(Log4jHandler.class);

    public void handler() {
        logger.info("log4j log");
    }
}
