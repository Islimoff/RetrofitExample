package com.job4j.retrofitexample.api;


import com.job4j.retrofitexample.model.Comment;
import com.job4j.retrofitexample.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int postId);

    @GET("/posts/{id}/comments")
    Call<List<Comment>>getComments(@Path("id") int postId);
}
