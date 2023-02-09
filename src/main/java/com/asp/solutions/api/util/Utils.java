package com.asp.solutions.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Utils {

    public String convertToJson(Object object){
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = new String();
        try {
            jsonData = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonData;
    }

    public Object convertToObject(String json){
        ObjectMapper mapper = new ObjectMapper();
        Object object;
        try {
            object = mapper.readValue(json, Object.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
