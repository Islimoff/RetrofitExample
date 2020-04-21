package com.job4j.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.job4j.retrofitexample.adapter.CommentAdapter;
import com.job4j.retrofitexample.model.Comment;
import com.job4j.retrofitexample.api.JsonPlaceHolderApi;
import com.job4j.retrofitexample.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi =
                retrofit.create(JsonPlaceHolderApi.class);

        final Post post = new Post(1, "title1", "text1");
        Call<Post> postCall = jsonPlaceHolderApi.putPost(1,post);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Post postResponce = response.body();
                    String content = String.format(
                            "ID:%s\nuser ID:%s\nTitle :%s\nText:%s\n\n",
                            postResponce.getId(), postResponce.getUserId(),
                            postResponce.getTitle(), postResponce.getText()
                    );
                    Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
