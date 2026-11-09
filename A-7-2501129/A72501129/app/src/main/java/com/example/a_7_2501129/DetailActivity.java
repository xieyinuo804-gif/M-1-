package com.example.a_7_2501129;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvResult = findViewById(R.id.tvResult);

        Intent intent = getIntent();
        int index = intent.getIntExtra("index",0);
        String fruitName = intent.getStringExtra("fruitName");

        tvResult.setText(index + " 번째 " + fruitName + "(을) 좋아합니다.");
    }

    public void goBack(View view){
        finish();
    }
}