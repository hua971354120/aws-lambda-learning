package com.fleetup.lambda.handler;

import java.util.Map;

/**
 * @author SZ Team David Hua
 * @date 2019/11/22
 * @desc
 */
public class EnvHandler {
    public void envHandle(String key) {
        /**
         * get all env variables
         */
        Map<String, String> envMap = System.getenv();
        if (envMap != null && !envMap.isEmpty()) {
            for (Map.Entry<String, String> entry : envMap.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
        System.out.println("=======================");
        String envValue = System.getenv(key);
        System.out.println(key + "=" + envValue);
    }
}
