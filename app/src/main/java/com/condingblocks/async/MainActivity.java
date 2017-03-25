package com.condingblocks.async;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    Button btnStart;
    Button btnDestroy;
    TextView tvProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnDestroy = (Button) findViewById(R.id.btnDestroy);
        
        btnDestroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvProgress = (TextView) findViewById(R.id.tvProgress);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask myTask = new MyTask();
                myTask.execute(10);
//                for (int i = 0; i < 10 ; i++){
//                    oneLoop();
//                    Log.d(TAG, "onClick: MainThread");
//                }
            }
        });


    }

    public class MyTask extends AsyncTask<Integer , Float , String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            Log.d(TAG, "onProgressUpdate: " + values[0]);
//            tvProgress.setText(values[0].toString());
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Integer... params) {
            for(int i = 0 ;i < params[0] ; i++){
                oneLoop();
                Log.d(TAG, "doInBackground: " + i);
//                publishProgress((float) i / (float) params[0]);
            }
            return "Completed";
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d(TAG, "onPostExecute: ");
            super.onPostExecute(s);
        }
    }

    static void oneLoop(){
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime  < 1000);
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
