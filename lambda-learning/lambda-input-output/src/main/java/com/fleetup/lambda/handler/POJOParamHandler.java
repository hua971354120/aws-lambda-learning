package com.fleetup.lambda.handler;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author SZ Team David Hua
 * @date 2019/11/22
 * @desc
 */
public class POJOParamHandler {

    @Getter
    @Setter
    @ToString
    class RequestDTO {
        private String request;
    }

    @Getter
    @Setter
    @ToString
    class ResponseDTO {
        private String response;
    }

    public ResponseDTO handle(RequestDTO request) {
        System.out.println("accept request : " + request.toString());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("response for " + request.getRequest());
        return responseDTO;
    }
}
