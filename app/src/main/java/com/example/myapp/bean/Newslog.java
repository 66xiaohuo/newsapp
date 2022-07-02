package com.example.myapp.bean;

import java.sql.Timestamp;

/**
 * @author luzikai
 * @ClassName Newslog.java
 * @Mail 1158523349@qq.com
 * @createTime 2022年06月21日 13:01:00
 */
public class Newslog {
    private int id;
    private int userid;
    private int newid;
    private Timestamp viewtime;
    private int like;//喜欢的程度

    public Newslog(int id, int userid, int newid, Timestamp viewtime, int like) {
        this.id = id;
        this.userid = userid;
        this.newid = newid;
        this.viewtime = viewtime;
        this.like = like;
    }
}
