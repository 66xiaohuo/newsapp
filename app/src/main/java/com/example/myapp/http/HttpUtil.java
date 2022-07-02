package com.example.myapp.http;

import android.app.Application;
import android.content.Context;

import com.example.myapp.NewsApplication;
import com.example.myapp.utils.GsonUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;

import java.io.File;
import java.util.HashMap;

/**
 * Created by luyy on 2017/5/3.
 */

public class HttpUtil {

    private static void init(Application application){
        HttpParams params = new HttpParams();
        //必须调用初始化
        OkGo.init(application);
    }


    private static boolean inited;
    private static void initOnce() {
        if (inited)
            return;
        inited = true;
            init(NewsApplication.getInstance());
    }

    public static PostRequest sendPost(Context context, String url, HashMap<String,Object> httpParams){
        initOnce();

        PostRequest request= OkGo.post(url);
        for(String key : httpParams.keySet()){
            if (httpParams.get(key) instanceof String) {
                request.params(key, (String) httpParams.get(key));
            }else if (httpParams.get(key) instanceof Integer) {
                request.params(key, (Integer) httpParams.get(key));
            }else {
                request.params(key, httpParams.get(key).toString());
            }
        }
//        if (!TextUtils.isEmpty(SpUtils.getString("token", ""))){
//            request.params("token", SpUtils.getString("token", SpUtils.getString("token", "")));
//            request.params("uid", SpUtils.getString("uid", SpUtils.getString("uid", "")));
//
//        }
        request= HttpManager.addHeader(request);
        request.tag(context).upJson(GsonUtil.serializedToJson(httpParams));
        return request;
    }

    public static PostRequest sendUploadPost(Context context, String url, HashMap<String,Object> httpParams){
        initOnce();

        PostRequest request= OkGo.post(url);
        for(String key : httpParams.keySet()){
            if (httpParams.get(key) instanceof String) {
                request.params(key, (String) httpParams.get(key));
            }else if (httpParams.get(key) instanceof Integer) {
                request.params(key, (Integer) httpParams.get(key));
            }else {
                request.params(key, (File)httpParams.get(key));
            }
        }
//        if (!TextUtils.isEmpty(SpUtils.getString("token", ""))){
//            request.params("token", SpUtils.getString("token", SpUtils.getString("token", "")));
//            request.params("uid", SpUtils.getString("uid", SpUtils.getString("uid", "")));
//
//        }
        request= HttpManager.addUploadHeader(request);
        return request;
    }


    public static GetRequest sendGet(Context context, String url, HashMap<String,Object> httpParams){
        initOnce();

        GetRequest request= OkGo.get(url);
        for(String key : httpParams.keySet()){
            if (httpParams.get(key) instanceof String) {
                request.params(key, (String) httpParams.get(key));
            }else {
                request.params(key, (Integer) httpParams.get(key));
            }
        }
        request= HttpManager.addGetHeader(request);
        return request;
    }


    public static PostRequest upload(String url, HashMap<String,Object> httpParams, File file){
        initOnce();

        PostRequest request= OkGo.post(url);
        for(String key : httpParams.keySet()){
            if (httpParams.get(key) instanceof String) {
                request.params(key, (String) httpParams.get(key));
            }else if (httpParams.get(key) instanceof Integer) {
                request.params(key, (Integer) httpParams.get(key));
            }
        }
        request= HttpManager.addHeader(request);
        request.params("file", file);
        return request;
    }
}
