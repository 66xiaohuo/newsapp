package com.example.myapp.http;

public interface UrlConstant {

    public static String localip = "http://127.0.0.1:8001";
    public static String serverip = "http://106.52.206.232:8001";
    public static String login="/login";
    public static String register="/user/register";
    public static String getRecnews="/user/new/getrecommend";
    /**
     * 注意这个要在背后加{id}
     */
    public static String getnewbyid="/user/new/getid/";
    /**
     * 注意这个要在背后加{catagory}
     */
    public static String getnewbycatagory="http://106.52.206.232:8002/admin/new/catagory/0";

    public static String getNews = "http://106.52.206.232:8001/user/new/getrecommend";
}

