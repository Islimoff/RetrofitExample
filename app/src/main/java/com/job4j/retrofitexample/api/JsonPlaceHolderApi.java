package com.job4j.retrofitexample.api;


import com.job4j.retrofitexample.model.Comment;
import com.job4j.retrofitexample.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int postId);

    @GET("/posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @PUT("posts{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts{id}")
    Call<Post> pathPost(@Path("id") int id, @Field("title") String title);

    @DELETE("posts{id}")
    Call<Void> deletePost(@Path("id") int id);
}
