package com.fleetup.lambda.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SZ Team David Hua
 * @date 2019/11/22
 * @desc lambda support Java basic type
 *          String/Integer/Boolean/Map/List
 */
public class SimpleParamHandler {
    public String handleString(String param) {
        System.out.println(String.format("accept String param : %s", param));
        return param;
    }

    public Integer handleInteger(Integer param) {
        System.out.println(String.format("accept Integer param : %d", param));
        return param;
    }

    public Boolean handleBoolean(Boolean param) {
        System.out.println(String.format("accept Integer param : %b", param));
        return param;
    }

    public Map<String, String> handleMap(Map<String, String> mapParam) {
        for (Map.Entry<String, String> entry : mapParam.entrySet()) {
            System.out.println(String.format("%s : %s", entry.getKey(), entry.getValue()));
        }

        Map<String, String> response = new HashMap<>(1);
        response.put("result", "success");
        return response;
    }

    public void handleList(List<String>listParam) {

    }
}
