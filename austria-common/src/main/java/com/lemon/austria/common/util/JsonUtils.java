package com.lemon.austria.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;


/**
 * json单元
 * @Author : garyhu480@gmail.com
 * @create 2022/12/18 04:44
 */
@Slf4j
public class JsonUtils {

    @Getter
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
    }

    public static String toJson(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T convert(Object obj, Class<T> cla) {
        return objectMapper.convertValue(obj,  cla);
    }

    public static <T> T fromJson(String json, TypeReference<T> type) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return (T) objectMapper.readValue(json, type);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static Object fromJson(String json, Type type) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructType(type));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> List<T> listFromJson(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            return Collections.emptyList();
        }
        return fromJson(json, new TypeReference<List<T>>() {
        });
    }
}

