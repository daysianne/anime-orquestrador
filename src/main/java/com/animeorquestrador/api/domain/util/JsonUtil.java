package com.animeorquestrador.api.domain.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    private static final Gson gson;

    static {
        gson = new GsonBuilder().create();
    }

    private JsonUtil() {}

    public static String paraJson(Object src) {
        return gson.toJson(src);
    }

    public static <T> T deJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}
