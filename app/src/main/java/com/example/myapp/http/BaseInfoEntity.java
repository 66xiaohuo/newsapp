package com.example.myapp.http;

import com.google.gson.JsonElement;


public class BaseInfoEntity {

    //Response
    private int code;
    private String msg;

    //Result
    public JsonElement data;

    public boolean isSuccess() {
        return HttpConfig.RESPONSE_CODE.SUCCESS == code;
    }

    public boolean hasResult() {
        return data != null;
    }

    /**
     * 请求返回码
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 错误信息
     * @return
     */
    public String getMessage() {
        return msg;
    }


}
