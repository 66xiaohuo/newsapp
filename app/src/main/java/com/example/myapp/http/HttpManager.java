package com.example.myapp.http;

import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;


/**
 * Created by luyy on 2017/5/3.
 */

public class HttpManager {

    static String token ="eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJlY2hpc2FuIiwic3ViIjoiMTIzIiwiaWF0IjoxNjU2NDAyMzg2LCJleHAiOjE2NTY4MzQzODZ9.4NVjED4u53z_1wpkTmoywSgaWPvHdTSGqozQjNVWRHY0_Ib92MlcqOmBZQ6WjWmkfqwik_bIlxa4kG9S20hVvQ";

    /**
     * 添加请求头
     *
     * @param requestBuilder
     * @return
     */
    protected static PostRequest addHeader(PostRequest requestBuilder) {

        requestBuilder.headers("Accept", "application/json");//
        requestBuilder.headers("Content-type", "application/json");//
         requestBuilder.headers("Authorization",token);

        return requestBuilder;
    }

    protected static GetRequest addGetHeader(GetRequest requestBuilder) {

        requestBuilder.headers("Accept", "application/json");//
        requestBuilder.headers("Content-type", "application/json");//
        requestBuilder.headers("Authorization",token);
        return requestBuilder;
    }

    protected static PostRequest addUploadHeader(PostRequest requestBuilder) {

        requestBuilder.headers("Accept", "application/json");//
        requestBuilder.headers("Content-type", "multipart/form-data");//
        return requestBuilder;
    }


}
