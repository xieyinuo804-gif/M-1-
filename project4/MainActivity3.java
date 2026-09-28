package com.example.project4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private ProgressBar pbIndeterminate, pbHorizontal, pbCircle, pbVertical;
    private TextView tvTopPercent, tvCirclePercent, tvVerticalPercent;
    private Button btnStart;
    private MyAsyncTask myTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        pbIndeterminate = findViewById(R.id.pbIndeterminate);
        pbHorizontal = findViewById(R.id.pbHorizontal);
        pbCircle = findViewById(R.id.pbCircle);
        pbVertical = findViewById(R.id.pbVertical);

        tvTopPercent = findViewById(R.id.tvTopPercent);
        tvCirclePercent = findViewById(R.id.tvCirclePercent);
        tvVerticalPercent = findViewById(R.id.tvVerticalPercent);

        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(v -> {

            if(myTask == null || myTask.getStatus() == AsyncTask.Status.FINISHED){
                myTask = new MyAsyncTask();
                myTask.execute();
            }
        });
    }

    class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            // 循环0~100，模拟后台任务
            for(int i = 0; i <= 100; i++){
                try {
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int progress = values[0];

            pbHorizontal.setProgress(progress);
            pbHorizontal.setSecondaryProgress(progress + 10); // 二级进度条，比主进度多一点，和截图一致
            pbCircle.setProgress(progress);
            pbVertical.setProgress(progress);

            tvTopPercent.setText(progress + "%");
            tvCirclePercent.setText(progress + "%");
            tvVerticalPercent.setText(progress + "%");
        }

        @Override
        protected void onPostExecute(Void unused) {

            tvTopPercent.setText("완료!");
        }
    }
}