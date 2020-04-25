package com.job4j.retrofitexample.retrofit;


import com.job4j.retrofitexample.model.Comment;
import com.job4j.retrofitexample.model.Post;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
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
    Observable<List<Post>> getPosts();

    @GET("posts/{id}")
    Observable<Post> getPost(@Path("id") int postId);

    @GET("/posts/{id}/comments")
    Observable<List<Comment>> getComments(@Path("id") int postId);

    @POST("posts")
    Single<Post> createPost(@Body Post post);

    @PUT("posts/{id}")
    Single<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}")
    Single<Post> pathPost(@Path("id") int id, @Field("title") String title);

    @DELETE("posts/{id}")
    Single<Response<Void>> deletePost(@Path("id") int id);
}
