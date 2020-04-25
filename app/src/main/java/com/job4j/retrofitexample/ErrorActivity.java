package com.job4j.retrofitexample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        TextView textView = findViewById(R.id.error_text);
        int code = getIntent().getIntExtra("error", 0);
        textView.setText("Responce code:" + String.valueOf(code));
    }
}
