package com.kuai.pojo;

//实体类
public class User {
    private int user_id;
    private String user_name;
    private String user_pubKey;

    public User() {
    }

    public User(int id, String name, String user_pubKey) {
        this.user_id = id;
        this.user_name = name;
        this.user_pubKey = user_pubKey;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public String getName() {
        return user_name;
    }

    public void setName(String name) {
        this.user_name = name;
    }

    public String getPwd() {
        return user_pubKey;
    }

    public void setPwd(String user_pubKey) {
        this.user_pubKey = user_pubKey;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", name='" + user_name + '\'' +
                ", user_pubKey='" + user_pubKey + '\'' +
                '}';
    }
}
