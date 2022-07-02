package com.example.myapp.http;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

public class JsonUtil {
    /**
     * 从文件中读取json数据
     * @param context
     * @param fileName
     * @return
     */
    public static String getJsonStr(Context context, String fileName) {
        StringBuilder stringBuffer = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String str = null;
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }

    /**
     * String转json
     */
    public static JSONObject string2Json(String str){
        try {
            return new JSONObject(str);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return new JSONObject();
    }


    /**
     * Json文件转list
     * @param context
     * @param fileName
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonFile(Context context, String fileName, Class<T> clazz) {
        String jsonStr = getJsonStr(context, fileName);

        List<T> lst = new ArrayList<T>();

        JsonArray array = new JsonParser().parse(jsonStr).getAsJsonArray();
        for (final JsonElement elem : array) {
            lst.add(new Gson().fromJson(elem, clazz));
        }

        return lst;
    }


    public static <T> List<T> fromJsonArray(String jsonStr, Class<T> clazz) {
        List<T> lst = new ArrayList<T>();
        try {

            JsonArray array = new JsonParser().parse(jsonStr).getAsJsonArray();
            for (final JsonElement elem : array) {
                lst.add(new Gson().fromJson(elem, clazz));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lst;
    }

    /**
     * Json转换成Entity数据
     * @return
     */
    public static HttpEntity Json2Entity(JSONObject json){
        ByteArrayEntity entity = null;
        try {
            entity = new ByteArrayEntity(json.toString().getBytes("UTF-8"));
            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,"application/json"));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return entity;
    }
}
