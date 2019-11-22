package com.fleetup.lambda.handler;

/**
 * @author SZ Team David Hua
 * @date 2019/11/22
 * @desc
 */
public class HelloHandler {
    public String handle() {
        System.out.println("Hello Lambda!");
        return "Hello Lambda!";
    }
}
