package com.example.myapp.http;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.example.myapp.utils.GsonUtil;
import com.google.gson.JsonSyntaxException;
import com.lzy.okgo.callback.StringCallback;

import java.lang.ref.WeakReference;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by luyingying on 2018/5/7.
 */
public class DataCallBack<E> extends StringCallback {

    WeakReference<Context> weakReference;

    protected Type resultClass;
    Context mContext;

    public DataCallBack(Context context, Class<E> resultClass) {
        this.resultClass = resultClass;
        mContext = context;
        weakReference = new WeakReference<Context>(context);
    }

    public DataCallBack(Context context, Type resultClass) {
        this.resultClass = resultClass;
        mContext = context;
        weakReference = new WeakReference<Context>(context);
    }

    @Override
    public void onError(Call call, Response response, Exception e) {
        super.onError(call, response, e);
        // Log.i("ysc",response.toString());
        onFailure(HttpConfig.RESPONSE_CODE.FAILURE, "网络连接失败");
    }

    @Override
    public void onSuccess(String result, Call call, Response response) {
//        if (weakReference.get() == null)
//            return;
        Log.i("intl-http", result);

        E resultBean;
        if (!TextUtils.isEmpty(result)) {
            try {
                //解析结果
                BaseInfoEntity infoBean = GsonUtil.getGson().fromJson(result, BaseInfoEntity.class);
                int code = Integer.parseInt(GsonUtil.getStringFromJSON(result, "code"));
                String msg = GsonUtil.getStringFromJSON(result, "msg");
                if (infoBean == null) {

                    onFailure(code, "解析实体为空");
                } else if (code == 200) {
                    if (infoBean.data == null) {
                        onSuccess(result);
                    } else {
                        resultBean = GsonUtil.getGson().fromJson(infoBean.data, resultClass);
                        onSuccess(resultBean);
                    }
                }else {
                    onFailure(infoBean.getCode(), infoBean.getMessage());
                }
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                onFailure(HttpConfig.RESPONSE_CODE.FAILURE, e.toString());
            }

        } else {
            onFailure(HttpConfig.RESPONSE_CODE.FAILURE, "返回数据为空");
        }

    }

    public void onFailure(int code, String msg) {

    }

    public void onFailure(String result) {
    }

    public void onSuccess(E result) {
    }


    public void onSuccess(String result) {

    }


}
