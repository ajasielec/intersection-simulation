package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // serialization
    public static String serialize(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    // deserialization
    public static <T> T deserialize(String json, Class<T> clazz) throws Exception {
        return objectMapper.readValue(json, clazz);
    }
}
