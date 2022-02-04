package com.example.rxjava_retrofit;

import com.google.gson.annotations.SerializedName;

public class MainData {

//    @SerializedName("userId")
    public String userId;
//    @SerializedName("id")
    public String id;
//    @SerializedName("title")
    public String title;
//    @SerializedName("body")
    public String body;

    public MainData(String userid, String id, String title, String body) {
        this.userId = userid;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}