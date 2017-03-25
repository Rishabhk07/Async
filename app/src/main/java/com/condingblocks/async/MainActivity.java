package com.condingblocks.async;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask myTask = new MyTask();
                myTask.execute(10);
//                for (int i = 0; i < 10 ; i++){
                    oneLoop();
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
            Log.d(TAG, "onProgressUpdate: " + values);
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Integer... params) {
            for(int i = 0 ;i < params[0] ; i++){
                oneLoop();
                Log.d(TAG, "doInBackground: " + i);
                publishProgress((float) i / (float) params[0]);
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    static void oneLoop(){
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime  < 1000);
    }

}
