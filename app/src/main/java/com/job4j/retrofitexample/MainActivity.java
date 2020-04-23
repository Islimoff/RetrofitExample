package com.job4j.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.job4j.retrofitexample.retrofit.JsonPlaceHolderApi;
import com.job4j.retrofitexample.model.Post;
import com.job4j.retrofitexample.retrofit.RetrofitClient;

import org.reactivestreams.Subscriber;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private EditText inputId, inputUserId, inputTitle, inputText;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputId = findViewById(R.id.text_id);
        inputUserId = findViewById(R.id.text_user_id);
        inputTitle = findViewById(R.id.text_title);
        inputText = findViewById(R.id.text_text);
        result = findViewById(R.id.result_text);
        Retrofit retrofit = RetrofitClient.getInstance();
        jsonPlaceHolderApi =
                retrofit.create(JsonPlaceHolderApi.class);
    }

    public void create(View view) {
        if (isInputUserId()) return;
        jsonPlaceHolderApi
                .createPost(getInputPost())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showResult);
    }

    public void update(View view) {
        if (isInputId()) return;
        jsonPlaceHolderApi
                .putPost(Integer.parseInt(inputUserId.getText().toString())
                        , getInputPost())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showResult);
    }

    public void delete(View view) {
        if (isInputId()) return;
        jsonPlaceHolderApi
                .deletePost(Integer.parseInt(inputId.getText().toString()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showDeletecode);
    }

    private void showDeletecode(Response<Void> response) {
        result.setText(String.valueOf(response.code()));
    }

    private void showResult(Post postResponce) {
        String content = String.format(
                "ID:%s\nuser ID:%s\nTitle :%s\nText:%s\n\n",
                postResponce.getId(), postResponce.getUserId(),
                postResponce.getTitle(), postResponce.getText()
        );
        result.setText(content);
    }

    private boolean isInputUserId() {
        boolean result = inputUserId.getText().toString().equals("");
        if (result) {
            Toast.makeText(getApplicationContext(), "Enter User Id!"
                    , Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    private boolean isInputId() {
        boolean result = inputId.getText().toString().equals("");
        if (result) {
            Toast.makeText(getApplicationContext(), "Enter Id!"
                    , Toast.LENGTH_SHORT).show();
        }
        return result;
    }

    private Post getInputPost() {
        final Post post = new Post(
                Integer.parseInt(inputUserId.getText().toString())
                , inputTitle.getText().toString()
                , inputText.getText().toString());
        return post;
    }
}
