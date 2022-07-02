package com.example.myapp.bean;

/**
 * @author luzikai
 * @ClassName User.java
 * @Mail 1158523349@qq.com
 */
public class Users{
    private int id;
    private String nickname;
    private String password;
    private String username;

    public Users(int id, String nickname, String password, String username) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
