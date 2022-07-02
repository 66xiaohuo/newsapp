package com.example.myapp.utils;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class GsonUtil {
    private static Gson gson;

    public static Gson getGson() {
        synchronized (GsonUtil.class) {
            if (gson == null) {
                gson = new Gson();
//                    gson=new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
            }
        }
        return gson;
    }

    private static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringAdapter();
        }
    }

    private static class StringAdapter extends TypeAdapter<String> {
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
//                writer.value("");
                return;
            }
            writer.value(value);
        }
    }

    /**
     * 从JSON字符串提取出对应 Key的 字符串
     *
     * @param json
     * @param key
     * @return
     */
    public static String getStringFromJSON(String json, String key) {
        String data = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            data = jsonObject.getString(key);
        } catch (JSONException e) {


        }
        return data;
    }

    public static String serializedToJson(Object object) {
        if (object != null) {
            if (gson == null) {
                gson = new Gson();
            }
            return gson.toJson(object);
        } else {
            return "";
        }
    }
}
