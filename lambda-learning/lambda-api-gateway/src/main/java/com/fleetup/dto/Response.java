package com.fleetup.dto;

import com.fleetup.common.ErrorCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author David Hua
 * @date 2019/12/9
 * @desc
 */
@Getter
@Setter
@ToString
public class Response<T> {
    private int code;

    private String message;

    private T data;

    private Response(){}

    public static Response buildSuccess() {
        Response response = new Response();
        response.setCode(ErrorCode.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }

    @SuppressWarnings("unchecked")
    public static <T> Response buildSuccess(T data) {
        Response response = buildSuccess();
        response.setData(data);
        return response;
    }

    public static Response buildResponse (int code, String message) {
        Response response = new Response();
        response.setCode(code);
        response.setMessage(message);

        return response;
    }
}
