package com.job4j.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

public class Post {

    private Integer userId;
    private Integer id;
    private String title;

    public Post(Integer userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    @SerializedName("body")
    private String text;

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
