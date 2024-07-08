package com.Triju.Mail.Domain.Helper;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonHelper{

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T getObjectFromJson(String json, Class<T> objectClass) throws IOException {
        return objectMapper.readValue(json, objectClass);
    }


}
