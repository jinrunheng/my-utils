package com.github.myutils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Dooby Kim
 * @Date 2023/4/12 8:09 下午
 * @Version 1.0
 */
@Slf4j
public class JSONUtils {
    /**
     * 将 Java 对象序列化为 JSON 字符串
     *
     * @return
     */
    public static String objectToJson(Object obj) throws RuntimeException {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("error message : {}, cause : {}", e.getMessage(), e.getCause());
            throw new RuntimeException(e);
        }
    }

    /**
     * 将 JSON 字符串反序列化为 Java 对象
     *
     * @param jsonStr
     * @return
     */
    public static Object jsonToObject(String jsonStr, Class<?> clazz) throws RuntimeException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            log.error("error message : {}, cause : {}", e.getMessage(), e.getCause());
            throw new RuntimeException(e);
        }
    }
}
