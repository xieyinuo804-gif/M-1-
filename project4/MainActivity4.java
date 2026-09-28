package com.example.project4;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    private SeekBar redBar, greenBar, blueBar;
    private TextView redText, greenText, blueText;
    private TextView resultView;

    int r = 0, g = 0, b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        resultView = findViewById(R.id.resultView);
        redText = findViewById(R.id.red);
        greenText = findViewById(R.id.green);
        blueText = findViewById(R.id.blue);

        redBar = findViewById(R.id.redBar);
        greenBar = findViewById(R.id.greenBar);
        blueBar = findViewById(R.id.blueBar);

        updateColor();

        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                r = progress;
                updateColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                g = progress;
                updateColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                b = progress;
                updateColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    void updateColor(){
        redText.setText(r + "(" + String.format("%02X", r) + ")");
        greenText.setText(g + "(" + String.format("%02X", g) + ")");
        blueText.setText(b + "(" + String.format("%02X", b) + ")");

        int color = Color.rgb(r,g,b);
        resultView.setBackgroundColor(color);
        String hex = String.format("%02X%02X%02X", r,g,b);
        resultView.setText(hex);
    }
}