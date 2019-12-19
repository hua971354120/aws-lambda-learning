package com.fleetup.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.*;

/**
 * @author SZ Team David Hua
 * @date 2019/11/22
 * @desc
 */
public class POJOParamHandler implements RequestHandler<RequestDTO, ResponseDTO> {

    @Override
    public ResponseDTO handleRequest(RequestDTO request, Context context) {
        System.out.println("accept request : " + request.toString());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("response for " + request.getRequest());
        return responseDTO;
    }
}

@Data
class RequestDTO {
    private String request;
}

@Data
class ResponseDTO {
    private String response;
}

