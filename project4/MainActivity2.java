package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    SeekBar seekBar;
    ProgressBar horizontalPb, circlePb, verticalPb;
    TextView tvPercent;
    TextView tvCircleText;
    Button btnPlus, btnMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        seekBar = findViewById(R.id.seekBar);
        horizontalPb = findViewById(R.id.horizontalPb);
        circlePb = findViewById(R.id.circlePb);
        verticalPb = findViewById(R.id.verticalPb);
        tvPercent = findViewById(R.id.tvPercent);
        tvCircleText = findViewById(R.id.tvCircleText);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);


        seekBar.setMax(100);
        horizontalPb.setMax(100);
        circlePb.setMax(100);
        verticalPb.setMax(100);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setAllProgress(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = seekBar.getProgress();
                if(now +10 <=100){
                    seekBar.setProgress(now+10);
                }
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int now = seekBar.getProgress();
                if(now -10 >=0){
                    seekBar.setProgress(now-10);
                }
            }
        });

    }

    void setAllProgress(int value){
        seekBar.setProgress(value);
        horizontalPb.setProgress(value);
        circlePb.setProgress(value);
        verticalPb.setProgress(value);
        tvPercent.setText("当前进度：" + value + " %");
        tvCircleText.setText(value + " %");
    }
}