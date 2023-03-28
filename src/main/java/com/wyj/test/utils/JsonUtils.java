package com.wyj.test.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {

    /**
     * Converts a JSON string to a Java object of the specified type.
     *
     * @param json the JSON string to convert
     * @param type the Java type to convert the JSON string to
     * @return the Java object that corresponds to the JSON string
     * @throws Exception if an error occurs while converting the JSON string
     */
    public static <T> T fromJson(String json, Class<T> type)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a Java object to a JSON string.
     *
     * @param object the Java object to convert
     * @return the JSON string that corresponds to the Java object
     * @throws Exception if an error occurs while converting the Java object
     */
    public static String toJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a JSON string to a Java List of the specified element type.
     *
     * @param json        the JSON string to convert
     * @param elementType the Java element type to convert the JSON string to
     * @return the Java List that corresponds to the JSON string
     * @throws Exception if an error occurs while converting the JSON string
     */
    public static <T> List<T> fromJsonToList(String json, Class<T> elementType) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<T>>() {
            @Override
            public Type getType() {
                return TypeFactory.defaultInstance().constructCollectionType(List.class, elementType);
            }
        });
    }
}
