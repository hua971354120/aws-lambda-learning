package com.fleetup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author David Hua
 * @date 2020/1/2
 * @desc
 */
public class LogHandler {

    private static final Logger logger = LoggerFactory.getLogger(LogHandler.class);

    public void handle(String message) {
        logger.info("Hello {}", message);
        logger.debug("Hello {}", message);
        logger.warn("Hello {}", message);
        logger.error("Hello {}", message);
        logger.trace("Hello {}", message);
    }
}
