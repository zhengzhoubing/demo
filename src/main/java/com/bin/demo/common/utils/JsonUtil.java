package com.bin.demo.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * package: com.bin.demo.common.utils
 * class: JsonUtil
 * description: TODO用一句话描述该文件做什么
 *
 * @author 85321 ZhengZhouBin
 * @date 2019/7/22 0022.
 **/
public class JsonUtil {
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtil.isEmpty(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
