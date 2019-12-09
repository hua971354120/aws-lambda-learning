package com.fleetup.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fleetup.dto.Response;
import com.fleetup.dto.UserRequestDTO;

/**
 * @author David Hua
 * @date 2019/12/9
 * @desc
 */
public class UserHandler implements RequestHandler<UserRequestDTO, Response> {
    @Override
    public Response handleRequest(UserRequestDTO userRequestDTO, Context context) {
        System.out.println("accept request : " + userRequestDTO.toString());
        Response response = Response.buildSuccess(userRequestDTO);
        System.out.println("return response : " + response.toString());
        return response;
    }
}
