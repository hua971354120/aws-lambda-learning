package com.fleetup.lambda;

import javax.sql.DataSource;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author David Hua
 * @date 2019/12/19
 * @desc
 */
public class MultiThreadHandler {
    private static DataSource dataSource;

    public void handle() throws InterruptedException {
        System.out.println("handler started");

        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("sub thread running");
        }, 1, 1, TimeUnit.SECONDS);
        Thread.sleep(5000);
        System.out.println("handler finished");
    }
}
