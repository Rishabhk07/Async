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
                myTask.execute();
                for (int i = 0; i < 10 ; i++){
//                    oneLoop();
                    Log.d(TAG, "onClick: MainThread");
                }
            }
        });


    }

    public class MyTask extends AsyncTask<Void , Void , Void>{

        @Override
        protected Void doInBackground(Void... params) {

            for (int i = 0 ; i < 10 ;i++){
                oneLoop();
                Log.d(TAG, "doInBackground: " + i);
            }

            return null;
        }
    }

    static void oneLoop(){
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime  < 1000);
    }

}
