package com.fleetup.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fleetup.dto.SimpleRequest;

/**
 * @author David Hua
 * @date 2019/12/9
 * @desc
 */
public class SimpleRequestHandler implements RequestHandler<SimpleRequest, String> {

    @Override
    public String handleRequest(SimpleRequest request, Context context) {
        System.out.println("accept request : " + request.getMessage());
        String response = String.format("Hello %s", request.getMessage());
        System.out.println("return response : " + response);
        return response;
    }
}
