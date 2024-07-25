package com.Triju.Mail.Domain.Helper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JsonHelper{

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static <T> T getObjectFromJson(String json, Class<T> objectClass) throws IOException {
        return objectMapper.readValue(json, objectClass);
    }


}
