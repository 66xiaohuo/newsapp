package com.example.myapp.http;

/**
 * Created by xunuo on 2016/2/29.
 */
public class HttpConfig {
    /**
     * 连接超时ms
     */
    public final static int    TIME_OUT_VALUE_CONNECT = 10000;
    /**
     * 获取返回超时ms
     */
    public final static int    TIME_OUT_VALUE_READ    = 20000;
    /**
     * 默认一百天过期
     **/
    public final static int    CACHE_EXPIRE_TIME      = 3600 * 24 * 100;
    public final static String DEVICE_TYPE            = "Android";
    public final static String SIGNTYPE               = "MD5";

    // 接口请求错误编号列表
    public static class RESPONSE_CODE {

        // 成功
        public static final int SUCCESS = 200;

        public static final int FAILURE = 100;

    }

    // 请求方式
    public static class REQUEST_METHOD {
        public static final int GET      = 1;
        public static final int POST     = 2;
        public static final int PUT      = 3;
        public static final int DOWNLOAD = 4;
        public static final int UPLOAD   = 5;
    }

    // 请求头参数
    public static class HEADER_PARAM_KEYS {
        public static final String DEVICE        = "x-client-device";//设备 Android
        public static final String VERSION       = "x-client-version";//版本号
        public static final String BUNDLEID      = "x-client-bundle-id";//包名
        public static final String UUID          = "x-client-device-uuid";//唯一号， 暂定MAC地址
        public static final String ANDROID_ID    = "x-client-android-id";//Android 唯一码
        public static final String IMEI          = "x-client-imei";//IMEI
        public static final String SERIAL_NUMBER = "x-client-serial-number";//序列码Build.SERIAL
        public static final String MAC           = "x-client-mac";//MAC地址
        public static final String PHONETYPE     = "x-client-phone-type";//手机型号
        public static final String OS            = "x-client-os-version";//系统版本
        public static final String NETWORK       = "x-client-network-type";//网络类型，暂时为空
        public static final String CHANNEL       = "x-client-channel-name";//友盟统计渠道
        public static final String SALT          = "x-client-dynamic-value";//随机盐值
        public static final String ACCESSTOKEN   = "x-client-accessToken";//账号令牌
    }

    public static class PARAM_KEYS {
        public static final String SERVICE  = "service";
        public static final String SIGNTYPE = "signType";
        public static final String SALT     = "salt";
        public static final String SIGN     = "sign";
    }
}
