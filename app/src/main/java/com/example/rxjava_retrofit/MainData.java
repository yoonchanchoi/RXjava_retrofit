package com.example.rxjava_retrofit;

import com.google.gson.annotations.SerializedName;

public class MainData {

    //@SerializedName("userid")
    private String userid;
    //@SerializedName("id")
    private String id;
    //@SerializedName("title")
    private String title;
    //@SerializedName("body")
    private String body;
    private int iv_1;


    public MainData(String userid, String id, String title, String body, int iv_1) {
        this.userid = userid;
        this.id = id;
        this.title = title;
        this.body = body;
        this.iv_1 = iv_1;
    }




    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public int getIv_1() {
        return iv_1;
    }

    public void setIv_1(int iv_1) {
        this.iv_1 = iv_1;
    }







}
